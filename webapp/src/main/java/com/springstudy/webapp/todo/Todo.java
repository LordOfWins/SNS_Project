package com.springstudy.webapp.todo;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class Todo {
  private boolean isDone;
  private int id;
  private String username;

  @Size(min = 10, message = "Enter at least 10 characters...")
  private String description;

  private LocalDate targetDate;

  public Todo(int id, String username, String description, LocalDate targetDate, boolean isDone) {
    this.id = id;
    this.username = username;
    this.description = description;
    this.targetDate = targetDate;
    this.isDone = isDone;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
  }

  public boolean isIsDone() {
    return isDone;
  }

  public void setIsDone(boolean isDone) {
    this.isDone = isDone;
  }

  @Override
  public String toString() {
    return "Todo{"
        + "id="
        + id
        + ", username='"
        + username
        + '\''
        + ", description='"
        + description
        + '\''
        + ", targetDate="
        + targetDate
        + ", isDone="
        + isDone
        + '}';
  }
}
