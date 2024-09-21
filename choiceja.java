import java.util.ArrayList;
import java.util.Scanner;







class Contact{




    private String name;




    private String phoneNumber;







    public Contact(String name, String phoneNumber){




        this.name=name;




        this.phoneNumber=phoneNumber;







    }




    public String getName(){




        return name;




    }







    public String getPhoneNumber(){




        return phoneNumber;




    }




}




class ContactManagementSystem{




    private ArrayList<Contact> contacts;




   




    public ContactManagementSystem(){




        this.contacts=new ArrayList<>();




    }







    public void addContact (String name, String phoneNumber){




        contacts.add(new Contact(name, phoneNumber));




        System.out.println("New contact added successfully!");




    }







    public void searchContact(String name){




        for(Contact contact:contacts){




            if(contact.getName().equalsIgnoreCase(name)){




                System.out.println("Contact found");




                System.out.println("Name "+contact.getName());




                System.out.println("Phone Number"+contact.getPhoneNumber());




                return;




            }




        }




        System.out.println("Contact not found");




    }







    public void displayAllContacts(){




        if(contacts.isEmpty()){




            System.out.println("No contacts Found");




            return;




        }




        System.out.println("All Contacts : ");







        for(Contact contact: contacts){




            System.out.println("Name "+contact.getName());




            System.out.println("Phone Number "+contact.getPhoneNumber());




            System.out.println();







        }




    }




}




public class choiceja {




    public static void main(String[] args){




        ContactManagementSystem c = new ContactManagementSystem();







        Scanner s = new Scanner(System.in);







        while(true){




            System.out.println("Enter Your choice");




            System.out.println("1 Add Contact");




            System.out.println("2 Search Contact");




            System.out.println("3 Display All Contacts");




            System.out.println("4 Exit");




            int choice = s.nextInt();




            s.nextLine();




            switch (choice) {




                case 1:




                    System.out.println("Enter name: ");




                    String name =s.nextLine();




                    System.out.println("Enter Phone number:");




                    String phoneNumber = s.nextLine();




                    c.addContact(name,phoneNumber);




                    break;




               




                case 2:




                    System.out.println("Enter name to search");




                    String searchName= s.nextLine();




                    c.searchContact(searchName);




                    break;




                case 3:




                    c.displayAllContacts();




                    break;




                case 4:




                    System.out.println("Existing contact management system");




                    s.close();




                    return;




                default:




                    System.out.println("Invalid choice Try again");




            }







        }




    }




}