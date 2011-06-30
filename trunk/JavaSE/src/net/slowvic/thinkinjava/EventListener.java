package net.slowvic.thinkinjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 事件驱动
 */
public class EventListener
{
	public static void main(String[] args)
	{
		Controller c = new Controller();
		c.addEvent(new Event(2000000000){
			@Override
			void action()
			{
				System.out.println("事件2被执行了");
			}
			@Override
			public String toString()
			{
				return "事件2";
			}
		});
		c.addEvent(new Event(100000000){
			@Override
			void action()
			{
				System.out.println("事件1被执行了");
			}
			@Override
			public String toString()
			{
				return "事件1";
			}
		});
		c.run();
	}
}

//定义事件接口，这里使用的是抽象类
abstract class Event
{
	private long eventTime;//事件触发时间
	protected final long delayTime; //事件在当前时间上的延迟
	
	public Event(long delayTime)
	{
		this.delayTime = delayTime;
		start();
	}
	
	public void start() //设置事件触发时间(当前时间+延迟)
	{
		eventTime = System.nanoTime() + delayTime;
	}
	
	public boolean ready()//判断是否已到触发时间
	{
		return System.nanoTime() > eventTime;
	}
	
	abstract void action(); //触发的事件，交给外界自定义
}

class Controller
{
	private List<Event> eventList = new ArrayList<Event>();//定义一个事件容器
	
	public void addEvent(Event event) //添加事件
	{
		eventList.add(event);
	}
	
	public void run()
	{
		while(!eventList.isEmpty()) //事件总会触发，所以不会死循环
		{
			for(Iterator<Event> itr = eventList.iterator();itr.hasNext();)
			{
				Event event = itr.next();
				if(event.ready()) //事件已经准备好
				{
					System.out.println(event); 
					event.action(); //执行事件
					itr.remove(); //从容器中删除事件，注意不能使用eventList.remove(event)
				}
			}
		}
	}
}