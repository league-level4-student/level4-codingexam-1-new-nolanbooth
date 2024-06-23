package scheduler;

import java.util.Scanner;

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

	public static void main(String[] args) {
		
		
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

				switch (day) {
				case "sunday":
					//System.out.println("ja");
//					if(week[0].schedule.getHead() != null) {
//					Node<Event> node = week[0].schedule.getHead();
//					bill: while (node != null) {
//						if (node.getValue().getTime() == hour) {
//							System.out.println("cannot add two events at the same time");
//						} else if (node.getValue().getTime() < hour) {
//							node = node.getNext();
//						} else if (node.getValue().getTime() > hour) {
//							week[0].schedule.add(new Event(hour, theEvent));
//							
//							break bill;
//						}
//					}
//				}else {
//					week[0].schedule.add(new Event(hour, theEvent));
//					
//					
//					
//				}
					
					week[0].schedule.add(new Event(hour, theEvent));
					break;
				case "monday":
					week[1].schedule.add(new Event(hour, theEvent));
					break;
				case "tuesday":
					week[2].schedule.add(new Event(hour, theEvent));
					break;
				case "wednesday":
					week[3].schedule.add(new Event(hour, theEvent));
					break;
				case "thursday":
					week[4].schedule.add(new Event(hour, theEvent));
					break;
				case "friday":
					week[5].schedule.add(new Event(hour, theEvent));
					break;
				case "saturday":
					week[6].schedule.add(new Event(hour, theEvent));
					break;
				}

				break;
			case "view":
				
				System.out.println("Which day?");
				String theDay = scan.nextLine();
				switch(theDay) {
				case "sunday":
					Node<Event> node = week[0].schedule.getHead();
					for(int i = 0; i < week[0].schedule.size(); i++) {
						System.out.println("Time: " + node.getValue().getTime() + " Thing: " + node.getValue().getDesc());
						node = node.getNext();
					}
					break;
				
				
				}
				break;
			case "remove":
				
				System.out.println("Which day?");

				break;
			case "quit":
				System.exit(0);
				
				
				break;
			default:
				

				//System.out.println("cannot understand");
			}
		} while (true);

	}
}
