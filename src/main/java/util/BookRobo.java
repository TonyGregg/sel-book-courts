package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created on Tue, 3/2/21 at 7:22 PM by Genil. Pay attention to release the key events; fail to do
 *  so may hang your machine.
 */
public class BookRobo {
  Robot robot = new Robot();

  public BookRobo() throws AWTException {}

  public static void main(String[] args) {
    BookRobo bookRobo = null;
    try {
      bookRobo = new BookRobo();
    } catch (AWTException e) {
      e.printStackTrace();
    }
    assert bookRobo != null;
    bookRobo.bookCourt();
  }

  private void bookCourt() {
    robot.setAutoDelay(40);
    robot.setAutoWaitForIdle(true);

    openBrowser();
    //    typeUrl(); // not required here. It is saved.
    typeUserNameAndPassword();

    clickReserveLink();

    select120Minutes();
    typeDate();
    selectFromTime();

    doSearch();
    select545Time();
    //
    confirmCourt();
    clickOkay();

    System.exit(0);
  }

  private void openBrowser() {
    robot.mouseMove(280, 1080);
    leftClick();
    robot.delay(6500); // Wait for the browser to open and load rush website

    // type tab for login
    type(KeyEvent.VK_TAB);
  }

  private void typeUrl() {
    type("rush"); // need only partial, browser has the complete URL in cache.
    robot.delay(200);
    type(KeyEvent.VK_RIGHT);
    robot.delay(200);
    type(KeyEvent.VK_ENTER);
    robot.delay(2000); // wait for few seconds for the page to load
  }

  private void typeUserNameAndPassword() {
    type("username"); // TODO change your username
    robot.delay(100);
    robot.keyPress(KeyEvent.VK_SHIFT);
    type(KeyEvent.VK_2);
    robot.keyRelease(KeyEvent.VK_SHIFT);
    robot.delay(100);

    type("gmail.com");
    robot.delay(200);
    type(KeyEvent.VK_TAB);
    // TODO password

    type("<yourpasswordgoeshere>");
    robot.keyPress(KeyEvent.VK_SHIFT);
    type(KeyEvent.VK_1);
    robot.keyRelease(KeyEvent.VK_SHIFT);

    robot.delay(200);
    type(KeyEvent.VK_ENTER);
  }

  private void clickReserveLink() {
    robot.delay(6000); // wait for few seconds for login.
    robot.mouseMove(110, 410);
    robot.delay(100);
    leftClick();
  }

  private void select120Minutes() {
    robot.delay(2500); // wait for few seconds for the page to load
    robot.mouseMove(750, 719 + 98); // original y 646
    robot.delay(100);
    leftClick();
  }

  private void typeDate() {
    robot.delay(500); // wait for few seconds for the page to load
    robot.mouseMove(362, 719 + 99);
    robot.delay(600);
    robot.delay(3000);
    leftClick();
    robot.delay(1000);

    robot.keyPress(KeyEvent.VK_META);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_META);
    robot.delay(500);
    LocalDate today = LocalDate.now();
    // TODO it should be always 14 days. To avoid real booking, change it to 14 + 1 or 2 days.
    LocalDate twoWeeksFromNowDate = today.plusDays(14);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String desiredDateStr = twoWeeksFromNowDate.format(formatter);
    type(desiredDateStr);

    //    type(KeyEvent.VK_PAGE_DOWN);
    //    type(KeyEvent.VK_PAGE_DOWN);
    //    type(KeyEvent.VK_PAGE_DOWN);
    System.out.println(twoWeeksFromNowDate.format(formatter));
  }

  private void selectFromTime() {

    robot.delay(200);
    robot.mouseMove(450, 808 + 70); // original 628
    robot.delay(100);
    leftClick();

    robot.delay(500); // TODO intentional manual delay. Remove it

    //    robot.mouseMove(452,618);
    // assuming this program runs at 12 O clock, press down key for 5 times & ENTER.
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_ENTER);
  }

  private void doSearch() {
    robot.delay(200);
    robot.mouseMove(360, 855 + 96); // original 685
    robot.delay(500);
    leftClick();

    robot.delay(2000); // wait for search
  }

  private void select545Time() {
    // scroll down a couple of times for the 5:45 to appear.
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);

    robot.mouseMove(360, 977);
    robot.delay(500);
    leftClick();

    robot.delay(1000); // wait pop-up
  }

  private void confirmCourt() {
    robot.delay(1500);
    robot.mouseMove(1230, 738);
    robot.delay(400);
    leftClick();
    robot.delay(5000);
  }

  private void clickOkay() {
    robot.mouseMove(1154, 608);
    robot.delay(2000);
    leftClick();
    robot.delay(2000);
  }

  private void leftClick() {
    //    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);
  }

  private void type(int i) {
    robot.delay(40);
    robot.keyPress(i);
    robot.keyRelease(i);
  }

  private void type(String s) {
    byte[] bytes = s.getBytes();
    for (byte b : bytes) {
      int code = b;
      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
      if (code > 96 && code < 123) code = code - 32;
      robot.delay(20);
      robot.keyPress(code);
      robot.keyRelease(code);
    }
  }
}
