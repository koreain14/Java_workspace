package human;
class UsePerson{
	public static void main(String[] args){
		WhitePerson w=new WhitePerson();
		System.out.println(w.color);
		w.openParty();

		w.walk();

		BlackPerson b=new BlackPerson();
		System.out.println(b.color);

		b.walk();
	}
}
