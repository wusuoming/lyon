package net.slowvic.thinkinjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * �¼�����
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
				System.out.println("�¼�2��ִ����");
			}
			@Override
			public String toString()
			{
				return "�¼�2";
			}
		});
		c.addEvent(new Event(100000000){
			@Override
			void action()
			{
				System.out.println("�¼�1��ִ����");
			}
			@Override
			public String toString()
			{
				return "�¼�1";
			}
		});
		c.run();
	}
}

//�����¼��ӿڣ�����ʹ�õ��ǳ�����
abstract class Event
{
	private long eventTime;//�¼�����ʱ��
	protected final long delayTime; //�¼��ڵ�ǰʱ���ϵ��ӳ�
	
	public Event(long delayTime)
	{
		this.delayTime = delayTime;
		start();
	}
	
	public void start() //�����¼�����ʱ��(��ǰʱ��+�ӳ�)
	{
		eventTime = System.nanoTime() + delayTime;
	}
	
	public boolean ready()//�ж��Ƿ��ѵ�����ʱ��
	{
		return System.nanoTime() > eventTime;
	}
	
	abstract void action(); //�������¼�����������Զ���
}

class Controller
{
	private List<Event> eventList = new ArrayList<Event>();//����һ���¼�����
	
	public void addEvent(Event event) //����¼�
	{
		eventList.add(event);
	}
	
	public void run()
	{
		while(!eventList.isEmpty()) //�¼��ܻᴥ�������Բ�����ѭ��
		{
			for(Iterator<Event> itr = eventList.iterator();itr.hasNext();)
			{
				Event event = itr.next();
				if(event.ready()) //�¼��Ѿ�׼����
				{
					System.out.println(event); 
					event.action(); //ִ���¼�
					itr.remove(); //��������ɾ���¼���ע�ⲻ��ʹ��eventList.remove(event)
				}
			}
		}
	}
}