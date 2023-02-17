package model.matcher;

import model.Task;

/**
 * An interface which implements match, to find tasks that match the different matchers.
 * @author Isak Wahlström
 */
public interface ITaskMatcher {
 /**
  *
  * @param task the task which is argument for match
  * @return true if the task matched.
  */
 public boolean match(Task task);
}
