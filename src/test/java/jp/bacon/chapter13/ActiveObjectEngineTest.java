package jp.bacon.chapter13;

import junit.framework.TestCase;
import junit.swingui.TestRunner;

public class ActiveObjectEngineTest extends TestCase {

  public static void main(String[] args) {
    TestRunner.main(new String[]{"jp.bacon.chapter13.ActiveObjectEngineTest"});
  }

  public ActiveObjectEngineTest(String name) {
    super(name);
  }

  private boolean firstCommandExecuted = false;

  public void testOneCommand() throws Exception {
    ActiveObjectEngine e = new ActiveObjectEngine();
    e.addCommand(
        new Command() {
          public void execute() {
            firstCommandExecuted = true;
          }
        }
    );
    e.run();
    assertTrue("Command not executed", firstCommandExecuted);
  }

  private boolean secondCommandExecuted = false;

  public void testTwoCommands() throws Exception {
    ActiveObjectEngine e = new ActiveObjectEngine();
    e.addCommand(
        new Command() {
          public void execute() {
            firstCommandExecuted = true;
          }
        }
    );
    e.addCommand(
        new Command() {
          public void execute() {
            secondCommandExecuted = true;
          }
        }
    );
    e.run();
    assertTrue("Commands not executed", firstCommandExecuted && secondCommandExecuted);
  }
}
