package com.example.todo.repository;

import com.example.todo.entity.Todo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {

  // 完了状態でフィルタリング
  List<Todo> findByCompleted(Boolean completed);

  // タイトルで部分一致検索
  List<Todo> findByTitleContainingIgnoreCase(String keyword);

  // 期限日が今日以前のもの
  List<Todo> findByDueDateLessThanEqual(LocalDate date);

  // 優先度でソート
  List<Todo> findAllByOrderByPriorityAsc();

  // @Query の例: 完了状態でフィルタリング
  @Query("select t from Todo t where t.completed = :completed")
  List<Todo> findByCompletedQuery(@Param("completed") Boolean completed);

  // @Query の例: タイトル部分一致検索
  @Query("select t from Todo t where t.title like concat('%', :keyword, '%')")
  List<Todo> searchByTitleLike(@Param("keyword") String keyword);

  // @Query の例: 期限日が今日以前 & 優先度昇順
  @Query("select t from Todo t where t.dueDate <= :date order by t.priority asc")
  List<Todo> findDueBeforeWithPriority(@Param("date") LocalDate date);
}
