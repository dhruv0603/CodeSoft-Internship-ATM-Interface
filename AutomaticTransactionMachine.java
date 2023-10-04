import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AutomaticTransactionMachine implements ActionListener {

    // Instance Variables
    JFrame         home,atmMenu;
    JDialog        credentialsWarning;
    JLabel         userId,title,userPin,name,aNumber;
    JLabel         accountName,accountNumber;
    Container      homeContainer,atmContainer;
    JButton        enter,showDetails,withdraw,deposit,exit;
    JTextField     customerId,userPinText;
    String[][]     userDetailString = new String[7][3];
    int[][]        userDetailInt    = new int[7][4];
    int            tableID;
    JButton        okForWrongUserID;
    JLabel         wrongUserID;
        // Account Variables
        String     accountHolderName;
        Long       accountHolderNumber;
        Float      accountHolderAmount;
        int        accountHolderPIN;
        String     accountHolderID;

    // Title
    public JLabel title() {
        title = new JLabel("ATM Application 2023");
        title.setBounds(340, 50, 400, 35);
        title.setFont(new Font("Arila",Font.BOLD,32));
        title.setForeground(new Color(0, 0, 153));
        return title;
    }

    public JLabel userId() {
        userId = new JLabel("User ID");
        userId.setBounds(300,100,200,30);
        userId.setFont(new Font("Arial",Font.BOLD, 28));
        userId.setBackground(Color.BLACK.darker());
        return userId;
    }

    public JLabel userPin() {
        userPin = new JLabel("PIN Code");
        userPin.setBounds(300,145,200,30);
        userPin.setFont(new Font("Arial",Font.BOLD, 28));
        userPin.setBackground(Color.BLACK.darker());
        return userPin;
    }

    // TextField
    public JTextField customerID() {
        customerId = new JTextField();
        customerId.setBounds(550,100,200,30);
        customerId.setFont(new Font("Arial",Font.BOLD,28));
        return customerId;
    }

    public JTextField userPinField() {
        userPinText = new JTextField();
        userPinText.setBounds(550,145,200,30);
        userPinText.setFont(new Font("Arial",Font.BOLD,28));
        return userPinText;
    }

    public JButton enterButton() {
        enter  = new JButton("Enter");
        enter.setBounds(400,250,140,40);
        enter.setFont(new Font("Arial",Font.BOLD,32));
        enter.setForeground(Color.white);
        enter.setBackground(new Color(51,204,255));
        return enter;
    }

    public JDialog warning() {
        credentialsWarning = new JDialog(home, "Warning ");
        credentialsWarning.setBounds(200,200,400,200);
        credentialsWarning.setResizable(false);
        credentialsWarning.setLayout(null);

        okForWrongUserID = new JButton("OK");
        okForWrongUserID.setBounds(100,90,80,25);
        okForWrongUserID.setFont(new Font("Arial",Font.BOLD,20));
        okForWrongUserID.setForeground(Color.white);
        okForWrongUserID.setBackground(new Color(51,204,255));
        credentialsWarning.add(okForWrongUserID);

        wrongUserID = new JLabel("Check userID or PIN");
        wrongUserID.setBounds(50,20,300,35);
        wrongUserID.setFont(new Font("Arial",Font.BOLD,28));
        wrongUserID.setForeground(Color.RED);
        credentialsWarning.add(wrongUserID);
        okForWrongUserID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                credentialsWarning.setVisible(false);
                home.dispose();
                main(null);
            }
        });
        return credentialsWarning;
    }

    AutomaticTransactionMachine() {
        home = new JFrame("ATM Application 2023");
        home.setBounds(100,100,1000,400);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ico = new ImageIcon("C:\\Users\\dhruv\\Desktop\\InternShip\\ATM Application 2023\\src\\icon.png");
        home.setIconImage(ico.getImage());
        home.setResizable(false);
        home.setVisible(true);
            //Container
            homeContainer = home.getContentPane();
            homeContainer.setLayout(null);
            Color homeBackgColor = new Color(102,255,102);
            homeContainer.setBackground(homeBackgColor);
            homeContainer.add(title());
            homeContainer.add(userId());
            homeContainer.add(userPin());
            homeContainer.add(customerID());
            homeContainer.add(userPinField());
            homeContainer.add(enterButton());
            enter.addActionListener(this);
    }
    // Main menu
        // Methods of main menu
        public JButton showDetails() {
            showDetails = new JButton("Show Details");
            showDetails.setBounds(150,200,220,35);
            showDetails.setFont(new Font("Arial",Font.BOLD,24));
            showDetails.setForeground(Color.white);
            showDetails.setBackground(new Color(51,204,255));
            showDetails.addActionListener(this);
            return showDetails;
        }

        public JButton withdraw() {
            withdraw = new JButton("Withdraw");
            withdraw.setBounds(150,260,220,35);
            withdraw.setFont(new Font("Arial",Font.BOLD,24));
            withdraw.setForeground(Color.white);
            withdraw.setBackground(new Color(51,204,255));
            withdraw.addActionListener(this);
            return withdraw;
        }
        
        public JButton deposit() {
            deposit = new JButton("Deposit");
            deposit.setBounds(550,200,220,35);
            deposit.setFont(new Font("Arial",Font.BOLD,24));
            deposit.setForeground(Color.white);
            deposit.setBackground(new Color(51,204,255));
            deposit.addActionListener(this);
            return deposit;
        }

        public JButton exit() {
            exit = new JButton("Exit");
            exit.setBounds(550,260,220,35);
            exit.setFont(new Font("Arial",Font.BOLD,24));
            exit.setForeground(Color.white);
            exit.setBackground(new Color(51,204,255));
            exit.addActionListener(this);
            return exit;
        }

        // Buttons Functions
        public void withdrawAmount() {
            try{

                // Previous Fun
                JFrame withdraw = new JFrame("ATM Application 2023");
                withdraw.setBounds(100,100,1000,400);
                withdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon ico = new ImageIcon("C:\\Users\\dhruv\\Desktop\\InternShip\\ATM Application 2023\\src\\icon.png");
                withdraw.setIconImage(ico.getImage());
                withdraw.setResizable(false);
                withdraw.setVisible(true);
                    // Container
                    Container withdrawCon = withdraw.getContentPane();
                    withdrawCon = withdraw.getContentPane();
                    withdrawCon.setLayout(null);
                    withdrawCon.setBackground(new Color(102,255,102));
                    withdrawCon.add(title());
                JLabel amountWithdraw = new JLabel("Enter the Amount");
                amountWithdraw.setBounds(200,150,400,30);
                amountWithdraw.setFont(new Font("Arial",Font.BOLD,28));
                amountWithdraw.setForeground(Color.BLACK);
                withdrawCon.add(amountWithdraw); 
                
                JLabel rs = new JLabel("Rs.");
                rs.setBounds(450,150,50,30);
                rs.setFont(new Font("Arial",Font.BOLD,27));
                rs.setForeground(Color.BLACK);
                withdrawCon.add(rs);

                JTextField amountWithdrawText = new JTextField();
                amountWithdrawText.setBounds(500,150,150,30);
                amountWithdrawText.setFont(new Font("Arial",Font.BOLD,26));
                amountWithdrawText.setForeground(Color.RED);
                withdrawCon.add(amountWithdrawText); 

                JButton with = new JButton("Withdraw");
                with.setBounds(380,250,200,30);
                with.setFont(new Font("Arial",Font.BOLD,28));
                with.setForeground(Color.white);
                with.setBackground(new Color(51,204,255));
                withdrawCon.add(with);

                with.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int amount = Integer.parseInt(amountWithdrawText.getText());
                        if(amount>userDetailInt[tableID][2]) {
                            JDialog balancewarning = new JDialog(home, "Warning ");
                            balancewarning.setBounds(200,200,400,200);
                            balancewarning.setResizable(false);
                            balancewarning.setLayout(null);
                            balancewarning.setVisible(true);

                            JButton okForBalnce = new JButton("OK");
                            okForBalnce.setBounds(100,90,80,25);
                            okForBalnce.setFont(new Font("Arial",Font.BOLD,20));
                            okForBalnce.setForeground(Color.white);
                            okForBalnce.setBackground(new Color(51,204,255));
                            balancewarning.add(okForBalnce);

                            JLabel wrongamount = new JLabel("Insufficient Balance");
                            wrongamount.setBounds(50,20,300,35);
                            wrongamount.setFont(new Font("Arial",Font.BOLD,28));
                            wrongamount.setForeground(Color.RED);
                            balancewarning.add(wrongamount);
                            okForBalnce.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       balancewarning.setVisible(false);
                                       home.dispose();
                                       withdraw.dispose();
                                       atmMenu();
                                    }
                            });
                        }
                        else {
                            userDetailInt[tableID][2]=userDetailInt[tableID][2]-amount;
                            try{
                            // Load class 
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            // Create connection
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankAccount","root", "Vijay.6565@#");
                            //Create a statement
                            Statement stmt = con.createStatement();

                            // Execute query
                            String sqlCommand = "update accountDetails"+" set amount="+String.valueOf(userDetailInt[tableID][2])+" where aNumber="+userDetailInt[tableID][1]+";";

                            stmt.executeUpdate(sqlCommand);
                            con.close();

                            // Dialog box
                            JDialog withdrawInfo = new JDialog(home, "Warning ");
                            withdrawInfo.setBounds(200,200,400,200);
                            withdrawInfo.setResizable(false);
                            withdrawInfo.setLayout(null);
                            withdrawInfo.setVisible(true);

                            JButton okForwith = new JButton("OK");
                            okForwith.setBounds(100,90,80,25);
                            okForwith.setFont(new Font("Arial",Font.BOLD,20));
                            okForwith.setForeground(Color.white);
                            okForwith.setBackground(new Color(51,204,255));
                            withdrawInfo.add(okForwith);

                            JLabel withInfo = new JLabel("Transaction Successful.");
                            withInfo.setBounds(50,20,300,35);
                            withInfo.setFont(new Font("Arial",Font.BOLD,21));
                            withInfo.setForeground(Color.RED);
                            withdrawInfo.add(withInfo);
                            okForwith.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       withdrawInfo.setVisible(false);
                                       home.dispose();
                                       withdraw.dispose();
                                       atmMenu();
                                    }
                            });

                            }catch(Exception exc) {
                                System.out.println(exc);
                            }
                        }
                    }
                });
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }

        // Deposite ammount
        public void depositAmount() {
            // Deposite frame
            JFrame deposite = new JFrame("ATM Application 2023");
            deposite.setBounds(100,100,1000,400);
            deposite.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon ico = new ImageIcon("C:\\Users\\dhruv\\Desktop\\InternShip\\ATM Application 2023\\src\\icon.png");
            deposite.setIconImage(ico.getImage());
            deposite.setResizable(false);
            deposite.setVisible(true);
                // Container
                Container depositeContainer = deposite.getContentPane();
                depositeContainer.setLayout(null);
                depositeContainer.setBackground(new Color(102,255,102));
                depositeContainer.add(title());

                JLabel amountWithdraw = new JLabel("Enter the Amount");
                amountWithdraw.setBounds(200,150,400,30);
                amountWithdraw.setFont(new Font("Arial",Font.BOLD,28));
                amountWithdraw.setForeground(Color.BLACK);
                depositeContainer.add(amountWithdraw); 
                
                JLabel rs = new JLabel("Rs.");
                rs.setBounds(450,150,50,30);
                rs.setFont(new Font("Arial",Font.BOLD,27));
                rs.setForeground(Color.BLACK);
                depositeContainer.add(rs);

                JTextField amountWithdrawText = new JTextField();
                amountWithdrawText.setBounds(500,150,150,30);
                amountWithdrawText.setFont(new Font("Arial",Font.BOLD,26));
                amountWithdrawText.setForeground(Color.RED);
                depositeContainer.add(amountWithdrawText); 

                JButton with = new JButton("Deposit");
                with.setBounds(380,250,200,30);
                with.setFont(new Font("Arial",Font.BOLD,28));
                with.setForeground(Color.white);
                with.setBackground(new Color(51,204,255));
                depositeContainer.add(with);

                with.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int amount = Integer.parseInt(amountWithdrawText.getText());
                        if(amount>100000) {
                            JDialog balancewarning = new JDialog(home, "Warning ");
                            balancewarning.setBounds(200,200,400,200);
                            balancewarning.setResizable(false);
                            balancewarning.setLayout(null);
                            balancewarning.setVisible(true);

                            JButton okForBalnce = new JButton("OK");
                            okForBalnce.setBounds(100,90,80,25);
                            okForBalnce.setFont(new Font("Arial",Font.BOLD,20));
                            okForBalnce.setForeground(Color.white);
                            okForBalnce.setBackground(new Color(51,204,255));
                            balancewarning.add(okForBalnce);

                            JLabel wrongamount = new JLabel("Maximum deposit is Rs. 1 Lakh");
                            wrongamount.setBounds(50,20,300,35);
                            wrongamount.setFont(new Font("Arial",Font.BOLD,18));
                            wrongamount.setForeground(Color.RED);
                            balancewarning.add(wrongamount);
                            okForBalnce.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       balancewarning.setVisible(false);
                                       home.dispose();
                                       deposite.dispose();
                                       atmMenu();
                                    }
                            });
                        }
                        else {
                            userDetailInt[tableID][2]=userDetailInt[tableID][2]+amount;
                            try{
                            // Load class 
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            // Create connection
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankAccount","root", "Vijay.6565@#");
                            //Create a statement
                            Statement stmt = con.createStatement();

                            // Execute query
                            String sqlCommand = "update accountDetails"+" set amount="+String.valueOf(userDetailInt[tableID][2])+" where aNumber="+userDetailInt[tableID][1]+";";

                            stmt.executeUpdate(sqlCommand);
                            con.close();

                            // Dialog box
                            JDialog withdrawInfo = new JDialog(home, "Warning ");
                            withdrawInfo.setBounds(200,200,400,200);
                            withdrawInfo.setResizable(false);
                            withdrawInfo.setLayout(null);
                            withdrawInfo.setVisible(true);

                            JButton okForwith = new JButton("OK");
                            okForwith.setBounds(100,90,80,25);
                            okForwith.setFont(new Font("Arial",Font.BOLD,20));
                            okForwith.setForeground(Color.white);
                            okForwith.setBackground(new Color(51,204,255));
                            withdrawInfo.add(okForwith);

                            JLabel withInfo = new JLabel("Deposited Successful.");
                            withInfo.setBounds(50,20,300,35);
                            withInfo.setFont(new Font("Arial",Font.BOLD,23));
                            withInfo.setForeground(Color.RED);
                            withdrawInfo.add(withInfo);
                            okForwith.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       withdrawInfo.setVisible(false);
                                       home.dispose();
                                       deposite.dispose();
                                       atmMenu();
                                    }
                            });

                            }catch(Exception exc) {
                                System.out.println(exc);
                            }
                        }
                    }
                });
        }

        // Show details
        public void showProfile() {
            //  Profile Frame
            JFrame profileFrame = new JFrame("ATM Application 2023");
            profileFrame.setBounds(100,100,1000,600);
            profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon ico = new ImageIcon("C:\\Users\\dhruv\\Desktop\\InternShip\\ATM Application 2023\\src\\icon.png");
            profileFrame.setIconImage(ico.getImage());
            profileFrame.setResizable(false);
            profileFrame.setVisible(true);
                // Container
                Container profileContainer = profileFrame.getContentPane();
                profileContainer.setLayout(null);
                profileContainer.setBackground(new Color(102,255,102));
                profileContainer.add(title());

                // Account class variables
                Account accountInformation = new Account();
                accountInformation.setAccountHolderName(userDetailString[tableID][1]);
                accountInformation.setAccountNumber(userDetailInt[tableID][1]);
                accountInformation.setAmount(userDetailInt[tableID][2]);
                accountInformation.setCustomerPIN(userDetailInt[tableID][3]);
                accountInformation.setUserID(userDetailString[tableID][2]);

                // Account Holder Name
                JLabel accountName = new JLabel("Account Holder Name");
                accountName.setBounds(100,100,400,30);
                accountName.setFont(new Font("Arial",Font.BOLD,28));
                accountName.setForeground(Color.BLACK);
                profileContainer.add(accountName);

                JLabel accountNameT = new JLabel(accountInformation.getAccountHolderName());
                accountNameT.setBounds(540,100,400,30);
                accountNameT.setFont(new Font("Arial",Font.BOLD,28));
                accountNameT.setForeground(Color.BLACK);
                profileContainer.add(accountNameT);

                // Account Number
                JLabel accountNumber = new JLabel("Account Number");
                accountNumber.setBounds(100,150,400,30);
                accountNumber.setFont(new Font("Arial",Font.BOLD,28));
                accountNumber.setForeground(Color.BLACK);
                profileContainer.add(accountNumber);

                JLabel accountN = new JLabel(String.valueOf(accountInformation.getAccountNumber()));
                accountN.setBounds(540,150,400,30);
                accountN.setFont(new Font("Arial",Font.BOLD,28));
                accountN.setForeground(Color.BLACK);
                profileContainer.add(accountN);

                // Account ID
                JLabel accountI = new JLabel("Account ID");
                accountI.setBounds(100,200,400,30);
                accountI.setFont(new Font("Arial",Font.BOLD,28));
                accountI.setForeground(Color.BLACK);
                profileContainer.add(accountI);

                JLabel accountID = new JLabel(accountInformation.getUserID());
                accountID.setBounds(540,200,400,30);
                accountID.setFont(new Font("Arial",Font.BOLD,28));
                accountID.setForeground(Color.BLACK);
                profileContainer.add(accountID);
                
                // Balance 
                JLabel balance = new JLabel("Available Balance");
                balance.setBounds(100,250,400,30);
                balance.setFont(new Font("Arial",Font.BOLD,28));
                balance.setForeground(Color.BLACK);
                profileContainer.add(balance);

                JLabel balanceL = new JLabel("Rs. "+String.valueOf(accountInformation.getAmount()));
                balanceL.setBounds(540,250,400,30);
                balanceL.setFont(new Font("Arial",Font.BOLD,28));
                balanceL.setForeground(Color.BLACK);
                profileContainer.add(balanceL);

                // Greeting label
                JLabel greeting = new JLabel(" *Thank You* ");
                greeting.setBounds(340,320,400,40);
                greeting.setFont(new Font("Arial",Font.BOLD,33));
                greeting.setForeground(Color.RED);
                profileContainer.add(greeting);

                // OK button 
                JButton goBack = new JButton("Go Back");
                goBack.setBounds(340,400,160,35);
                goBack.setFont(new Font("Arial",Font.BOLD,26));
                goBack.setForeground(Color.white);
                goBack.setBackground(new Color(51,204,255));
                profileContainer.add(goBack);

                goBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        profileFrame.dispose();
                        atmMenu();
                    }    
                });

        }


    public void atmMenu() {
        atmMenu = new JFrame("ATM Application 2023");
        atmMenu.setBounds(100,100,1000,400);
        atmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ico = new ImageIcon("C:\\Users\\dhruv\\Desktop\\InternShip\\ATM Application 2023\\src\\icon.png");
        atmMenu.setIconImage(ico.getImage());
        atmMenu.setResizable(false);
        atmMenu.setVisible(true);
            // Container
            atmContainer = atmMenu.getContentPane();
            atmContainer.setLayout(null);
            atmContainer.setBackground(new Color(102,255,102));
            atmContainer.add(title());

            // Name
            name = new JLabel("Name");
            name.setBounds(150,100,300,35);
            name.setFont(new Font("Arila",Font.BOLD,28));
            name.setForeground(Color.BLACK);
            atmContainer.add(name);

            accountName= new JLabel(userDetailString[tableID][1]);
            accountName.setBounds(500,100,400,35);
            accountName.setFont(new Font("Arila",Font.BOLD,28));
            accountName.setForeground(Color.BLACK);
            atmContainer.add(accountName);

            aNumber = new JLabel("Account Number");
            aNumber.setBounds(150,150,300,35);
            aNumber.setFont(new Font("Arila",Font.BOLD,28));
            aNumber.setForeground(Color.BLACK);
            atmContainer.add(aNumber);

            accountNumber = new JLabel(String.valueOf(userDetailInt[tableID][1]));
            accountNumber.setBounds(500,150,400,35);
            accountNumber.setFont(new Font("Arila",Font.BOLD,28));
            accountNumber.setForeground(Color.BLACK);
            atmContainer.add(accountNumber);

            // Main Menu Buttons
            atmContainer.add(showDetails());
            atmContainer.add(withdraw());
            atmContainer.add(deposit());
            atmContainer.add(exit());
    }

    
    // Account verify
    public void verifyAccount() {
        Account account = new Account();
        account.setUserID(customerId.getText());
        account.setCustomerPIN(Integer.parseInt(userPinText.getText()));
        // Checking 
        boolean flag1 = false;
        boolean flag2 = false;
        for(int i=0;i<7;i++) {
            for(int j=0;j<3;j++) {
                if(userDetailString[i][2].equals(account.getUserID())) {
                    flag1 = true;
                    tableID=i;
                }
            }
        }
        for(int i=0;i<7;i++) {
            for(int j=0;j<4;j++) {
                if(userDetailInt[i][3]==account.getCustomerPIN()) {
                    flag2=true;
                    tableID=i;
                }
            }
        }
        if(flag1==true && flag2==true) {
            atmMenu();
            home.dispose();
        }
        else {
            warning().setVisible(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==enter) {
            verifyAccount();
        }
        else if(e.getSource()==exit) {
            atmMenu.dispose();
            home.dispose();
        }
        else if(e.getSource()==withdraw) {
            atmMenu.dispose();
            home.dispose();
            withdrawAmount();
        }
        else if(e.getSource()==deposit) {
            atmMenu.dispose();
            home.dispose();
            depositAmount();
        }
        else if(e.getSource()==showDetails) {
            atmMenu.dispose();
            home.dispose();
            showProfile();
        }
        
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        AutomaticTransactionMachine a = new AutomaticTransactionMachine();
        try{
            // Load class 
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankAccount","root", "Vijay.6565@#");
            Statement stmt = con.createStatement();  
            ResultSet result = stmt.executeQuery("select * from accountDetails");
            int i=0;
            while(result.next()) {
                if(i==7) {
                    break;
                }
                int k=0;
                a.userDetailInt[i][k]=i ;
                a.userDetailString[i][k]=String.valueOf(i);
                k++;
                a.userDetailInt[i][k]=result.getInt(2);
                a.userDetailString[i][k]=result.getString(1);
                k++;
                a.userDetailInt[i][k]=result.getInt(3);
                a.userDetailString[i][k]=result.getString(5);
                k++;
                a.userDetailInt[i][k]=result.getInt(4);
                i++;
            }
            con.close();          

        }catch(Exception e) {
            System.out.println(e);
        }
    }
}