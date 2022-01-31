package com.lgcns.icst.lecture.servletjsp.lec3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FreeBoardData {

    private static Long sequence = 1L;
    private static final List<FreeBoard> freeBoards = new ArrayList<>(Arrays.asList(
            new FreeBoard(FreeBoardData.sequence++, "손흥민 영양실조로 쓰러져...", "'위'에 아무것도 없어", "ㅇㅇ"),
            new FreeBoard(FreeBoardData.sequence++, "[BBC] 발롱도르 결국 손상돼...", "'SON' 상 돼...", "ㅇㅇ2"),
            new FreeBoard(FreeBoardData.sequence++, "야 포체티노", "축구 할 때 'SON'을 쓰는 건 반칙이잖아...", "ㅇㅇ"),
            new FreeBoard(FreeBoardData.sequence++, "무적의 전술을 찾아버렸다", "'SON'자병법", "ㅇㅇ"),
            new FreeBoard(FreeBoardData.sequence++, "대한민국 탈모 확산세...", "손흥민에게 '헤어'나올 수 없어...", "ㅇㅇ1")));

    public static List<FreeBoard> findAll() {
        return FreeBoardData.freeBoards;
    }

    public static void addData(String title, String content, String createdBy) {
        FreeBoard data = new FreeBoard(FreeBoardData.sequence++, title, content, createdBy);
        FreeBoardData.freeBoards.add(data);
    }
}
