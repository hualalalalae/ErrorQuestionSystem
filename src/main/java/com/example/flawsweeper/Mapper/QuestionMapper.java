package com.example.flawsweeper.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.flawsweeper.Entity.ErrorQuestion;
import com.example.flawsweeper.Entity.dto.RedoQuestionDTO;
import com.example.flawsweeper.Entity.vo.QuestionVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionMapper extends BaseMapper<ErrorQuestion> {
     //显示错题所有信息
     Map<String, Object> getQuestionMessage(int questionid);

     //添加错题
     boolean addQuestion(ErrorQuestion errorQuestion);

     //获取错题类（不包括分类名称，分类名称在classify类），用于修改错题信息
     ErrorQuestion getQuestionClass(int questionid);

     //添加回收站内
     boolean updateinrecycle(int questionid);

     //修改
     boolean updateQuestion(ErrorQuestion errorQuestion);
     //添加收藏
     boolean Intocollect(int questionid);
     //移除收藏夹
     boolean updateIncollect(int questionid);
     //从回收站恢复
     @Update("update  errorquestion set inrecycle = 0 where questionid = #{questionid}")
     boolean recoverQuestion(int questionid);

     /**
      * 获取所有符合条件的错题
      * @param redoQuestionDTO
      * @return
      */
     @MapKey(value = "questionid")
     List<Map<String,Object>> getRedoQuestion(RedoQuestionDTO redoQuestionDTO);

}
