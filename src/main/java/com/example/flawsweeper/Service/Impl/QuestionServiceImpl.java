package com.example.flawsweeper.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.flawsweeper.Controller.QuestionController;
import com.example.flawsweeper.Entity.ErrorQuestion;
import com.example.flawsweeper.Entity.dto.RedoQuestionDTO;
import com.example.flawsweeper.Entity.vo.QuestionVo;
import com.example.flawsweeper.Mapper.ClassifyMapper;
import com.example.flawsweeper.Mapper.QuestionMapper;
import com.example.flawsweeper.Service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, ErrorQuestion> implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ClassifyMapper classifyMapper;

    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    public Map<String, Object> getQuestionMessage(int questionid){

        return questionMapper.getQuestionMessage(questionid);
    }

    @Override
    public boolean addQuestion(ErrorQuestion errorQuestion) {
        //添加错题后，获取错题的id
        boolean flag = questionMapper.addQuestion(errorQuestion);
        return flag;
    }

    @Override
    public ErrorQuestion getQuestionClass(int questionid) {
        return questionMapper.getQuestionClass(questionid);
    }

    @Override
    public boolean updateinrecycle( int questionid) {
        return questionMapper.updateinrecycle(questionid);
    }

    @Override
    public boolean updateQuestion(ErrorQuestion errorQuestion) {
        return questionMapper.updateQuestion(errorQuestion);
    }

    @Override
    public boolean deleteCollect(int questionid) {

        return questionMapper.updateIncollect(questionid);
    }

    @Override
    public boolean intocollect(int questionid) {
        return questionMapper.Intocollect(questionid);
    }

    @Override
    public boolean recoverQuestion(int questionid) {
        return questionMapper.recoverQuestion(questionid);
    }

    /**
     * 获取所有重做错题
     * @param redoQuestionDTO
     * @return
     */
    @Override
    public List<Map<String,Object>> getRedoQuestion(RedoQuestionDTO redoQuestionDTO) {
        //获取所有符合条件的错题
        List<Map<String,Object>> errorQuestions = questionMapper.getRedoQuestion(redoQuestionDTO);
//        System.out.println("title22222:"+errorQuestions.get(0).getTitle2());
        System.out.println("获取到的错题数量："+errorQuestions.size());
        System.out.println("获取的所有符合条件错题："+errorQuestions);
        //随机选取5道
        // 打乱列表顺序
        Collections.shuffle(errorQuestions);
        // 选取前5个元素
        List<Map<String,Object>> randomQuestions = errorQuestions.subList(0, Math.min(5, errorQuestions.size()));
        System.out.println("选取前5个元素:"+randomQuestions);
        return randomQuestions;
    }
}
