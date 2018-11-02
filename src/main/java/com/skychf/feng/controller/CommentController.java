package com.skychf.feng.controller;

import com.skychf.feng.api.Result;
import com.skychf.feng.entity.Comments;
import com.skychf.feng.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    /**
     * 用户旅游评论
     * @param tiebaId
     * @param body
     * @param userid
     * @return
     */
    @PostMapping("comment")
    public Result store(@RequestParam("tieba_id") Integer tiebaId, @RequestParam("body") String body, @RequestParam("user_id") Integer userid) {
        Comments comment= new Comments();
        comment.setBody(body);
        comment.setUserId(userid);
        comment.setTiebaId(tiebaId);
        try {
            commentRepository.save(comment);
            return Result.success("评论成功");
        } catch (Exception e) {
            return Result.error("评论失败");
        }
    }
}
