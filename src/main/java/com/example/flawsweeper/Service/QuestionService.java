package com.example.flawsweeper.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.flawsweeper.Entity.ErrorQuestion;
import com.example.flawsweeper.Entity.dto.RedoQuestionDTO;
import com.example.flawsweeper.Entity.vo.QuestionVo;

import java.util.List;
import java.util.Map;


public interface QuestionService extends IService<ErrorQuestion> {
     //根据错题id获取错题所有信息
     Map<String, Object> getQuestionMessage(int questionid);

      //添加错题
      boolean addQuestion(ErrorQuestion errorQuestion);

      //根据错题id获取错题类，方便修改信息
      ErrorQuestion getQuestionClass(int questionid);


      //修改是否在回收站内
      boolean updateinrecycle(int questionid);

      //修改
      boolean updateQuestion(ErrorQuestion errorQuestion);

      //收藏
      boolean intocollect(int questionid);
      //移出收藏夹
      boolean deleteCollect(int questionid);
      //从回收站恢复
      boolean recoverQuestion(int questionid);

     /**
      * 获取所有重做错题
      * @param redoQuestionDTO
      * @return
      */
     List<Map<String,Object>> getRedoQuestion(RedoQuestionDTO redoQuestionDTO);
}
