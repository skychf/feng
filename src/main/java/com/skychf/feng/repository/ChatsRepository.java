package com.skychf.feng.repository;

import com.skychf.feng.entity.Chats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatsRepository extends JpaRepository<Chats, Integer> {
}
