package com.example.flawsweeper.Entity.vo;

import com.example.flawsweeper.Entity.ErrorQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVo extends ErrorQuestion{
    private String classifyname;
}
