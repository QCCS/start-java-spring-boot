##文件操作
1：File(掌握)

	(1)File是用来描述硬盘上的文件或者文件夹的
	
	(2)File的构造方法
	
		A:File file = new File("d:\\demo\\a.txt");
		B:File file = new File("d:\\demo","a.txt");
		C:File file = new File("d:\\demo");
		  File file2 = new File(file,"a.txt");
		  
	(3)File的成员方法(自己补齐方法和中文意思)
	
		A:创建功能
			CreateNewFile()
			mkdir()
			mkdirs()
			
		B:删除功能
			delete()
			
		C:重命名功能
			renameTo()
			
		D:判断功能
			isDirectory()
			isFile()
			exists()
			isHidden()
			canWrite()
			canRead()
			
		E:基本获取功能
			get三个
			lastModifiedTime
			length
			
		F:高级获取功能
			String[] filename = file.list()
			File[] fileArray = file.listFiles()
		G:文件名称过滤器
		
	(4)案例：
		输出指定目录下指定后缀名结尾的文件名称