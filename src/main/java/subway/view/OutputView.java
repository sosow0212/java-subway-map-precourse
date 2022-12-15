package subway.view;

public class OutputView {
    private static final String INFO = "[INFO]";

    public void printMainSelect() {
        System.out.println("## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료");
    }

    public void printRequestOfSelect() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public void printStationSelect() {
        System.out.println("## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기");
    }

    public void printRequestOfUploadingStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }

    public void printUploadStationSuccessfully() {
        System.out.println(INFO + " 지하철 역이 등록되었습니다.");
    }

    public void printAllStations() {
        // todo : 매개변수로 역 목록 받고, 출력

    }

    public void printRequestOfRemovingStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
    }

    public void printRemoveSuccessfully() {
        System.out.println(INFO + " 지하철 역이 삭제되었습니다.");
    }

    public void printRequestOfUploadingLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
    }

    public void printRequestOfFirstLine() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public void printRequestOfLastLine() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public void printUploadingLineSuccessfully() {
        System.out.println(INFO + " 지하철 노선이 등록되었습니다.");
    }

    public void printShowAllLines() {
        // todo : 노선 목록 출력
    }

    public void printRequestOfRemovingLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
    }

    public void printRemovingLineSuccessfully() {
        System.out.println(INFO + " 지하철 노선이 삭제되었습니다.");
    }
}
