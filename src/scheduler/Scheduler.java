package scheduler;

import java.util.Scanner;
import java.util.TreeMap;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */
public class Scheduler {

	static daysOfWeek[] week = daysOfWeek.values();

	public static void main(String[] args) throws SchedulingConflictException {
		
		
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("Type in what you want to do below (add, view, remove, quit) ");
			String event = scan.nextLine();

			switch (event) {
			case "add":
				
				
				System.out.println("What is the event?");
				String theEvent = scan.nextLine();
				
				System.out.println("What hour will your event take place?");
				int hour = scan.nextInt();
				
				
				
				
				System.out.println("What day of the week?");
				String day;
				day = scan.next();
				int theDayCounter = 0;
				
				Node<Event> node = week[theDayCounter].schedule.getHead();
				theDayCounter = daysOfWeek.valueOf(day.toUpperCase()).ordinal();
				node = week[theDayCounter].schedule.getHead();
				for(int i = 0; i < week[theDayCounter].schedule.size(); i++) {
					if(hour == node.getValue().getTime()) {
						throw new SchedulingConflictException("cannot add two things at the same time!");
					}
						node = node.getNext();
						
					}
				week[theDayCounter].schedule.add(new Event(hour, theEvent));
				
				

				break;
			
			case "view":
				
				System.out.println("Which day?");
				String theDay = scan.nextLine();
				int dayNumber = daysOfWeek.valueOf(theDay.toUpperCase()).ordinal();;
				
				TreeMap<Integer, Event> tree = new TreeMap<Integer, Event>();
				node = week[dayNumber].schedule.getHead();
				
				for(int i = 0; i < week[dayNumber].schedule.size(); i++) {
					tree.put(node.getValue().getTime(), node.getValue());
					node = node.getNext();
					
					
				}
				
				System.out.println("Schedule: ");
				
				for(Event e : tree.values()) {
					System.out.println(e.toString());
				}
				
				
				break;
			case "remove":
				
				System.out.println("Which day?");
				String theDay1 = scan.nextLine();
				int dayNumber1 = daysOfWeek.valueOf(theDay1.toUpperCase()).ordinal();
				
				
				System.out.println("What time?");
				int theHour = scan.nextInt();
				
				node = week[dayNumber1].schedule.getHead();
				
				for(int i = 0; i < week[dayNumber1].schedule.size(); i++) {
					if(node.getValue().getTime() == theHour) {
						week[dayNumber1].schedule.remove(i);
					}else {
						node = node.getNext();
					}
					
					
				}
				
				
				break;
			case "quit":
				System.out.println("ok");
				
				System.exit(0);
				
				
				break;
			default:
				

				//System.out.println("cannot understand");
			}
		} while (true);

	}
}
