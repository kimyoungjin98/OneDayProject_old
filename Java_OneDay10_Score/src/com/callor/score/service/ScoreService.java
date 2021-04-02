package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	int totalKor;
	int totalEng;
	int totalMath;
	int totalSci;
	int totalHis;
	int total;
	int intSum;
	float floatAvg;
	float totalAvg;

	public ScoreService() {

		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();

	}

	public void scoreMenu() { // TODO 메뉴출력

		while (true) {

			System.out.println(LinesSerivce.dLines(50));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println(LinesSerivce.dLines(50));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println(LinesSerivce.dLines(50));
			System.out.print("업무선택 >> ");

			String strMenu = scan.nextLine();
			Integer intMenu = null;

			if (strMenu.equals("QUIT")) {
				break;
			}
			try {
				intMenu = Integer.valueOf(strMenu);

			} catch (Exception e) {
				System.out.println("메뉴 선택 오류");
				System.out.println("1, 2, QUIT만 입력하세요");
				continue;
			}
			if (intMenu == 1) {
				this.input();
			} else if (intMenu == 2) {
				this.printScore();
			}
		} // while() end
		System.out.println("업무 종료 ! ");
	}

	public void input() {

		ScoreVO vo = new ScoreVO();
		String strName;

		while (true) {

			System.out.println(LinesSerivce.dLines(50));
			System.out.println("학생 이름을 입력하세요(입력을 중단하려면 QUIT)");
			System.out.println(LinesSerivce.dLines(50));

			System.out.print("이름 >> ");
			strName = scan.nextLine();
			if (strName.equals("QUIT")) {
				return;
			} else {
				break;
			}

		}

		System.out.println(LinesSerivce.dLines(50));
		System.out.printf("%s 학생의 성적을 입력하세요(성적범위 : 0 ~ 100, 입력중단 : QUIT)\n", strName);
		System.out.println(LinesSerivce.dLines(50));

		this.inputScore(vo);

		vo.setStrName(strName);
		scoreList.add(vo);

		System.out.println(LinesSerivce.dLines(50));
		System.out.printf("%s 학생의 성적이 추가 되었습니다\n", strName);
		System.out.println(LinesSerivce.dLines(50));
		System.out.printf("국어 : %d\n", vo.getIntKor());
		System.out.printf("영어 : %d\n", vo.getIntEng());
		System.out.printf("수학 : %d\n", vo.getIntMath());
		System.out.printf("과학 : %d\n", vo.getIntSci());
		System.out.printf("국사 : %d\n", vo.getIntHis());

	}

	public void inputScore(ScoreVO vo) {

		Integer intScore = null;
		
		this.inputKor(vo);
		this.inputEng(vo);
		this.inputMath(vo);
		this.inputSci(vo);
		this.inputHis(vo);

		intSum = vo.getIntKor() + vo.getIntEng() + vo.getIntMath() + vo.getIntSci() + vo.getIntHis();
		floatAvg = (float) intSum / 5;

		vo.setIntSum(intSum);
		vo.setFloatAvg(floatAvg);

		totalKor += vo.getIntKor();
		totalEng += vo.getIntEng();
		totalMath += vo.getIntMath();
		totalSci += vo.getIntSci();
		totalHis += vo.getIntHis();

		total = totalKor + totalEng + totalMath + totalSci + totalHis;

	}

	public void printScore() {

		System.out.println(LinesSerivce.dLines(50));
		System.out.println("이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println(LinesSerivce.sLines(50));

		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);

			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%3.2f\n", vo.getStrName(), vo.getIntKor(), vo.getIntEng(),
					vo.getIntMath(), vo.getIntSci(), vo.getIntHis(), vo.getIntSum(), vo.getFloatAvg());

			totalAvg = (float) total / 5 / scoreList.size();
		}

		System.out.println(LinesSerivce.dLines(50));
		System.out.printf("총점\t%d\t%d\t%d\t%d\t%d\t%d\t%3.2f\n", totalKor, totalEng, totalMath, totalSci, totalHis,
				total, totalAvg);

	}

	public void inputKor(ScoreVO vo) {
		
		while (true) {
			System.out.print("국어 (0부터 100까지, 입력중단:QUIT) >> ");
			String strKor = scan.nextLine();
			Integer intKor = Integer.valueOf(strKor);
			vo.setIntKor(intKor);
			if (intKor < 0 || intKor > 100) {
				System.out.println("0부터 100까지만 입력");
				continue;
			} else if(strKor.equals("QUIT")) {
				return;
			} else {
				break;
			}

		}
	}

	public void inputEng(ScoreVO vo) {
		while (true) {
			System.out.print("영어 (0부터 100까지, 입력중단:QUIT) >> ");
			String strEng = scan.nextLine();
			Integer intEng = Integer.valueOf(strEng);
			vo.setIntEng(intEng);
			if (intEng < 0 || intEng > 100) {
				System.out.println("0부터 100까지만 입력");
				continue;
			} else {
				break;
			}
		}

	}

	public void inputMath(ScoreVO vo) {
		while (true) {
			System.out.print("수학 (0부터 100까지, 입력중단:QUIT) >> ");
			String strMath = scan.nextLine();
			Integer intMath = Integer.valueOf(strMath);
			vo.setIntMath(intMath);
			if (intMath < 0 || intMath > 100) {
				System.out.println("0부터 100까지만 입력");
				continue;
			} else {
				break;
			}
		}

	}

	public void inputSci(ScoreVO vo) {
		while (true) {
			System.out.print("과학 (0부터 100까지, 입력중단:QUIT) >> ");
			String strSci = scan.nextLine();
			Integer intSci = Integer.valueOf(strSci);
			vo.setIntSci(intSci);
			if (intSci < 0 || intSci > 100) {
				System.out.println("0부터 100까지만 입력");
				continue;
			} else {
				break;
			}
		}
	}

	public void inputHis(ScoreVO vo) {
		while (true) {
			System.out.print("역사 (0부터 100까지, 입력중단:QUIT) >> ");
			String strHis = scan.nextLine();
			Integer intHis = Integer.valueOf(strHis);
			vo.setIntHis(intHis);
			if (intHis < 0 || intHis > 100) {
				System.out.println("0부터 100까지만 입력");
				continue;
			} else {
				break;
			}
		}
	}

}
