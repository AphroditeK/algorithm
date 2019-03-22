package util;

import java.lang.reflect.Method;

public class Timer {
	
	/**
	 * 计算方法调用所需时间（毫秒级）
	 * @param clazz 要方法所在类的全限定名
	 * @param methodName 要调用的方法名
	 * @param paramsType 调用方法的参数类型
	 * @param params 调用方法要求的参数，按顺序填写
	 * @return
	 * know more:请使用基本数据类型的封装类型进行使用数据
	 * int类型-Integer
	 * double类型-Double...
	 */
	public static Long timeMillisTimer(Class<?> clazz,String methodName,Object... params){
		Long beginTime = null;
		Long overTime = null;
		Class<?>[] paramsType = new Class<?>[params.length];
		if(params != null){
			for(int i=0;i<params.length;i++){
				//这里会出现一个问题就是
				//基本数据类型的getClass方法会得到的是该类型的封装类型
				//所以调用方法也要用封装类型传参才能被识别并成功调用
				paramsType[i] = params[i].getClass();
			}
		}
		try {
			//要得到方法一定要传入参数类型，这是由于java方法有重载的特性所以要有参数类型才能准确寻找一个方法
			Method method = clazz.getMethod(methodName,paramsType);
			beginTime = System.currentTimeMillis();
			method.invoke(clazz.newInstance(), params);
			overTime = System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return overTime-beginTime;
	}
	
}
