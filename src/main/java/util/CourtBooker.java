package util;

import java.awt.AWTException;

/**
 * Created on Wed, 3/3/21 at 1:35 PM by Genil.
 * This is the organizer class, talks to SeleniumCourtBookHelper and BookRobo classes
 * and orchestrate the book clicks.
 */
public class CourtBooker {
  public static void main(String[] args) throws AWTException {
    CourtBooker courtBooker = new CourtBooker();
    courtBooker.doAutoCourtBooking();

  }

  private void doAutoCourtBooking() throws AWTException {
    SeleniumCourtBookHelper seleniumCourtBookHelper = new SeleniumCourtBookHelper();
    seleniumCourtBookHelper.loginAndClickReserveLink();

//    seleniumCourtBookHelper.closeBrowser();
  }

}
