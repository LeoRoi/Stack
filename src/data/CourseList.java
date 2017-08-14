package data;

public enum CourseList {
	law, music, science, maths, art, medicine;
	
	public static CourseList select(){
		int select;
        System.out.printf("\n\t1 law\n"
                + "\t2 music\n"
                + "\t3 science\n"
                + "\t4 maths\n"
                + "\t5 art\n"
                + "\t6 medicine\n"
                + "__________________\n"
                + "your choice >> ");
        
        select = stack.Tools.intCheck(0, 6);        
        switch(select) {
            
            case 1:
            	return law;
                
            case 2:
            	return music;
                
            case 3:
            	return science;
                
            case 4:
            	return maths;
                
            case 5:
            	return art;
                
            case 6:
            	return medicine;
                
        }
		return null;
	}
}
