
public class DataFile {
	
	
	Xls_Reader d = new Xls_Reader("C:\\Excel\\NikulTest.xlsx");
	
	
	public String validEmail = d.getCellData("Data1", "UserName", 2);
	public String invalidEmail1 =d.getCellData("Data1", "UserName", 3);
	public String invalidEmail2 = d.getCellData("Data1", "UserName", 4);
	public String invalidPassword = d.getCellData("Data1", "Password", 2);
	public String PasswordMessage = d.getCellData("Data1", "Password Error", 2);//"Wrong password. Try again";
	public String EmailMessage1= d.getCellData("Data1", "Email Error", 2);//"Enter a valid email or phone number";
	public String EmailMessage2= d.getCellData("Data1", "Email Error", 3);//"Couldn't find your Google Account";
}
