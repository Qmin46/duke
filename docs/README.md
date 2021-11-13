# Duke
This is a chatbot which is build by using Java. 

## User Guide
User will required to input their to-dos, deadline or event to their schedule. User can refer to the guidance for the template to be input.

## Features 

### Error Handling
Duke is able to deal with errors such as incorrect inputs entered by the user.

### Assertions
document important assumptions that should hold at various points in the code.

### Object Orientated Programming (OOP)
Refactor the code to extract out closely related code as classes.

## Usage

### todo
description		: return error message as there is no to-do task in the input.
expected outcome	: ☹ OOPS!!! The description of a todo cannot be empty.

### todo borrow book
description		: to input task (borrow book) without any date/time attached to it.
expected outcome	: Got it. I've added this task: 
       			  [T][ ] borrow book
     			  Now you have 5 tasks in the list.

### list 
description		: display out all the existing task that already input to the user when requested.
expected outcome	: Here are the tasks in your list:
     			  1.[T] borrow book

### deadline 
description		: return error message as there is no date or time details after deadline description.
expected outcome	: ☹ OOPS!!! The description of a todo cannot be empty.


### deadline return book /by Sunday
description		: to input task (return book) that need to be done before Sunday.
expected outcome	: Got it. I've added this task: 
       			  [D][ ] return book (by: Sunday)
     			  Now you have 2 tasks in the list.

### deadline do homework /by no idea :-p
description		: to input task (do homework) that need to be done before no idea :-p.
expected outcome	: Got it. I've added this task: 
       			  [D][ ] do homework (by: no idea :-p)
     			  Now you have 3 tasks in the list.

### deadline submit homework /by 2021-11-13 23:00
description		: to input task (submit homework) that need to be done before 13 November 2021, 11pm.
expected outcome	: Got it. I've added this task: 
       			  [D][ ] submit homework (by: 13th of November 2021, 11pm)
     			  Now you have 4 tasks in the list.

### event 
description		: return error message as there is no date or time details after event description. 
expected outcome	: ☹ OOPS!!! The description of an event cannot be empty.


### event meeting /at Mon 2pm-4pm
description		: to input task (event meeting) that start at 2pm and ends at 3pm.
expected outcome	: Got it. I've added this task: 
       			  [E][ ] borrow book (at: Mon 2-4pm)
     			  Now you have 5 tasks in the list.

### done 1
description		: mark task no.1 as done.
expected outcome	: Nice! I've marked this task as done: 
       			  [X] borrow book

### delete 1
description		: delete the task no. 1 from the schedule.
expected outcome	: Noted. I've removed this task: 
 			  [T][X] borrow book

### bye
description		: exit the chatbot, Duke
expected outcome	: Bye. Hope to see you again soon!
