ArrayList<String> myArray = new ArrayList<String>();
        
        myArray.add("myFirst");
        System.out.println(myArray.get(0));
        
        for (int i = 0; i < 10; i++) {
            myArray.add("element-" + i);
        }
        
        System.out.println(myArray.get(6));
        myArray.add(3, "myElement");
        System.out.println(myArray.get(6));
        
        System.out.println("size=" + myArray.size());
        
        System.out.println("----------");
        for (int i = 0; i < myArray.size() ; i++) {
            System.out.println(myArray.get(i));
        }
        System.out.println("----------");
        for (int i = 7; i < 10; i++) {
            myArray.remove(i);
        }
        
        System.out.println("size = " + myArray.size());
        System.out.println("----------");
        for (int i = 0; i < myArray.size() ; i++) {
            System.out.println(myArray.get(i));
        }
        System.out.println("----------");
        
        myArray.set(6, "Changed");
        
        myArray.add("Changed");
        
        System.out.println("size = " + myArray.size());
        System.out.println("----------");
        for (int i = 0; i < myArray.size() ; i++) {
            System.out.println(myArray.get(i));
        }
        System.out.println("----------");
        
        
        
        int pos = myArray.indexOf("Changed");
        
        System.out.println(pos);
        
        System.out.println(myArray.contains("myFirst") );
        
        int last = myArray.size();
        myArray.set( last - 1 , "Last");
        
        
        System.out.println("size = " + myArray.size());
        System.out.println("----------");
        for (int i = 0; i < myArray.size() ; i++) {
            System.out.println(myArray.get(i));
        }
        System.out.println("----------");
        
        
        
        ArrayList<String> myNewArray = new ArrayList<String>();
        
        myNewArray.add("element-0");
        myNewArray.add("myFirst");
        myNewArray.add("Last");
        
        System.out.println(myArray.containsAll(myNewArray));
        
        myNewArray.add("New");
        System.out.println(myArray.containsAll(myNewArray));
        
        myNewArray.clear();
        printArray(myNewArray);
        
        
        HashMap<String, String> local = new HashMap<String, String>();
        
        local.put("id", "1");
        local.put("name", "Villiem");
        local.put("job", "farmer");
        local.put("age", "32");
        local.put("sex", "man");
        local.put("salary", "$60");
        
        
        System.out.println("id:"+local.get("id")+"\n"+"job:"+local.get("job")+"\n"+"name:"+local.get("name"));
        
        
        
