package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Created on Tue, 3/2/21 at 7:22 PM by Genil.
 */
public class BookRobo {
  Robot robot = new Robot();

  public BookRobo() throws AWTException {
  }

  public static void main(String[] args) {
    BookRobo bookRobo = null;
    try {
      bookRobo = new BookRobo();
    } catch (AWTException e) {
      e.printStackTrace();
    }
    bookRobo.bookCourt();
  }

  /**
   *
   * @return 1 if it is successful, 0 otherwise.
   */
  public int changeDurationDateAndFromTime() {
    select120Minutes();
    typeDate();
    selectFromTime();

    return 1;
  }

  private  void bookCourt() {robot.setAutoDelay(40);
    robot.setAutoWaitForIdle(true);

    openBrowser();
    typeUrl();

    typeUserNameAndPassword();

    clickReserveLink();
    select120Minutes();
    typeDate();

    selectFromTime();

    doSearch();
    select545Time();

    confirmCourt();

    clickOkay();

    System.exit(0);
  }

  private void openBrowser() {
    robot.mouseMove(202, 862);
    robot.delay(500);

    leftClick();
    robot.delay(500);
    leftClick();
    robot.delay(1500); // Wait for the safari to load.
  }

  private void typeUrl() {
    type("rush"); // type only partial as the browser is already has the URL in cache
    robot.delay(200);
    type(KeyEvent.VK_RIGHT);
    robot.delay(200);
    type(KeyEvent.VK_ENTER);
    robot.delay(2000); // wait for few seconds for the page to load
  }

  private void typeUserNameAndPassword() {
    robot.mouseMove(820, 252);
    robot.delay(100);
    leftClick();
    robot.delay(100);
    type("antonygenil");
    robot.delay(100);
    robot.keyPress(KeyEvent.VK_SHIFT);
    type(KeyEvent.VK_2);
    robot.keyRelease(KeyEvent.VK_SHIFT);
    robot.delay(100);

    type("gmail.com");
    robot.delay(200);
    //password is stored in browser, so just tab, press down key and enter twice
    type(KeyEvent.VK_TAB);
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_ENTER);
    robot.delay(200);
    type(KeyEvent.VK_ENTER);

  }

  private void clickReserveLink () {
    robot.delay(6000); // wait for few seconds for login.
    robot.mouseMove(110, 400);
    robot.delay(100);
    leftClick();

  }

  private void select120Minutes() {
    robot.delay(2500); // wait for few seconds for the page to load
    robot.mouseMove(756, 646);
    robot.delay(100);
    leftClick();
  }

  private void typeDate() {
    robot.delay(500); // wait for few seconds for the page to load
    robot.mouseMove(360, 646);
    robot.delay(100);
    leftClick();

    robot.keyPress(KeyEvent.VK_META);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_META);
    robot.delay(500);
    LocalDate today = LocalDate.now();
    LocalDate twoWeeksFromNowDate = today.plusDays(14); //TODO change it back to 14 days
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String desiredDateStr = twoWeeksFromNowDate.format(formatter);
    type(desiredDateStr);

    type(KeyEvent.VK_PAGE_DOWN);
    type(KeyEvent.VK_PAGE_DOWN);
    type(KeyEvent.VK_PAGE_DOWN);
    System.out.println( twoWeeksFromNowDate.format(formatter));
  }

  private void selectFromTime() {

    robot.delay(200);
    robot.mouseMove(450, 616);
    robot.delay(100);
    robot.delay(5000); // TODO intentional manual delay. Remove it

    leftClick();
    robot.mouseMove(452,618);
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
    robot.mouseMove(360, 680);
    robot.delay(500);
    leftClick();

    robot.delay(1000); // wait for search
  }

  private void select545Time() {
    // scroll down a couple of times for the 5:45 to appear.
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);
    type(KeyEvent.VK_DOWN);

    robot.mouseMove(360, 705);
    robot.delay(500);
    leftClick();

    robot.delay(1000); // wait pop-up
  }

  private void confirmCourt() {
    robot.delay(1500);
    robot.mouseMove(1035, 633);
    robot.delay(1000);
    leftClick();
    robot.delay(5000);

  }

  private void clickOkay() {
    robot.mouseMove(980, 500);
    robot.delay(3000);
    leftClick();
    robot.delay(5000);
  }


  private void leftClick()
  {
//    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);
  }

  private void type(int i)
  {
    robot.delay(40);
    robot.keyPress(i);
    robot.keyRelease(i);
  }

  private void type(String s)
  {
    byte[] bytes = s.getBytes();
    for (byte b : bytes)
    {
      int code = b;
      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
      if (code > 96 && code < 123) code = code - 32;
      robot.delay(40);
      robot.keyPress(code);
      robot.keyRelease(code);
    }
  }
}
