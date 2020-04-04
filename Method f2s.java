public static String f2s(String file) throws IOException{
    File name = new File("file");
	Scanner input = new Scanner(name);
	String content = "";
	if (name.exists()){
		return null;
	}
	else{
		while (input.hasNext()){
			content += input.nextLine();
		}
		return content;
	}
	
}