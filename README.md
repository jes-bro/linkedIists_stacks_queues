# Practice Problems with Stacks and Queues

## Problem 1:
Implemented in code. Essentially, put the stack into a queue (pop from the stack and enqueue with the queue) and dequeue from the queue to push into the stack. Queues are first in first out versus last in first out, so the order of information gets reversed when added back to the stack. 

## Problem 2: 
As I find open brackets, I would add them to a stack. I won't encounter a closing bracket that doesn't match the top of the stack if the string is valid. For instance: 

{[]} is valid, so when I have the stack <br/> 
[
<br/> 
{
<br/> 
and encounter the first closing bracket, ], 
it will match the top of the stack. 
But if the string is invalid:<br/> 
{[[} <br/> 
My stack will look like:
<br/> 
[
<br/> 
[
<br/> 
}
and the closing bracket } will not match. 
So if I find the first closed bracket I encounter does not match the bracket at the top of my stack, the string is invalid so I would return false. Only if the stack is empty by the end of the string would it return true. 

## Problem 3: 
First, I would create a stack, a queue, and another stack. <br/> 

stack 1: 1, 2, 3 <br/> 
queue: null <br/> 
stack 2: null<br/> 

I would then then pop from the stack and enqueue to the queue: <br/> 

stack 1: 1, 2, 3 <br/> 
index: 1, 2, 3 (Last in will be first out, so index 3 goes first, then 2, etc.) <br/> 
so queue the will be filled like so: <br/> 
queue: 3, 2, 1 <br/> 
index: 1, 2, 3  <br/> 

Queue is first in first out (index 1, then 2, then 3 out), so if you dequeue the items and push them back to the stack, you will get: <br/> 
stack: 3, 2, 1 <br/> 
index: 1, 2, 3 <br/> 

To get the queue to have the right order, you pop and enqueue again: <br/> 
LIFO means you pop index 3, 2, 1, so the queue will be: <br/> 
queue: 1, 2, 3 <br/> 
index: 1, 2, 3 <br/> 

The queue will dequeue in (index) order 1, 2, 3, (First in (1), first out) which will yield the order of the original stack. So, now I can dequeue from the queue and push each dequeued item into both stacks. That way, I end up with:<br/> 
queue: null<br/> 
stack 1: 1, 2, 3<br/> 
stack 2: 1, 2, 3<br/> 




