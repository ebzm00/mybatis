package io.goorm.mybatis.board;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter

public class Board {

    private Long seq;

    private String title;

    private String contents;

    private String regUser;

    private LocalDateTime regDate;

}
