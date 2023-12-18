package eero.dogfood;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class CreateNetworkCases extends BaseTest {
	@Test(enabled = true, priority = 2, description = "Delete network")
	void DeleteNetwork() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.clickHome();
		settingsPage settingspage = new settingsPage(driver);
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		homepage.clickSettings();
		settingspage.clickNetworkSettings();
		networkSettingsPage.deleteNetwork();
		deleteNetworkPage deletenetworkpage = new deleteNetworkPage(driver);
		deletenetworkpage.deleteNetwork();
		deletenetworkpage.confirmDelete();

	}

	@Test(enabled = false)

	void TurnOnGuest() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingspage = new settingsPage(driver);
		settingspage.clickGuestconf();
		editGuestNetworkPage editguestpage = new editGuestNetworkPage(driver);
		editguestpage.clickenableGuestToggle();
		String guestname = editguestpage.getGuestNetworkName();
		String guestpassword = editguestpage.getGuestPassword();
		editguestpage.saveGuestChanges();
		Activity activity1 = new Activity("com.android.settings",
				"com.android.settings.homepage.SettingsHomepageActivity");
		driver.startActivity(activity1);
		clientConnectPage clientconnectpage = new clientConnectPage(driver);
		clientconnectpage.clickNetwork();
		clientconnectpage.clickInternet();
		homePage.clickActivity();

	}

	@Test(enabled = false, priority = 1, description = "Createnetwork dhcp network")

	void createNetwork() throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		homePage.clickStartSetup();
		startSetupPage startsetuppage = new startSetupPage(driver);
		startsetuppage.clickStartBtn();
		addOrReplaceEeroPage addorreplacepage = new addOrReplaceEeroPage(driver);
		addorreplacepage.clickArrowBtn();
		addorreplacepage.clickArrowBtn();
		addorreplacepage.clickArrowBtn();
		placementTestPage placementtest = new placementTestPage(driver);
		placementtest.selectLoc();
		addorreplacepage.enterNetworkName("My Name");
		addorreplacepage.setNetworkPassword("11112222");
		addorreplacepage.clickArrowBtn();
		addorreplacepage.clickArrowBtn();
		addorreplacepage.clickInstallNow();
		homePage.clickJoinBtn();
		startsetuppage.clickSkip();
		homePage.clickJoinBtn();

	}

	@Test(enabled = false)
	public void changeDhcpToManual() throws InterruptedException {
		// TODO Auto-generated method stub
		// goto homepage
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingspage = new settingsPage(driver);
		settingspage.clickNetworkSettings();
		NetworkSettingsPage networksettingspage = new NetworkSettingsPage(driver);
		networksettingspage.clickDhcpNat();
		dhcpNatConfPage dhcpnatconf = new dhcpNatConfPage(driver);
		dhcpnatconf.selectManualIpoption();
		dhcpnatconf.selectManulaIpaddr();
		dhcpnatconf.clickSave();
		dhcpnatconf.clickReboot();
		homePage.clickHome();
		String internetstat = homePage.getInternetStatus();
		if (internetstat == "Online") {
			System.out.println("Network is Online");
		} else {
			System.out.println(internetstat);
		}

	}

}
