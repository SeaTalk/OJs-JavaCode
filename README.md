# OJs-JavaCode
This is a repository for Online Judge codes. <B> Specifically for Java. </B>
---
# Problems
### 1. NewCalculater
> Problem Discription:  								
当你学一些可视化程序设计语言时，老师经常会让你设计并且编程做出一个计算器，这时也许你会仿照windows系统自带的计算器外观和功能去设计，但是现在老师要你多做出一个有新功能的计算器，实现当输入一个数时，能够将这个数分解成一个或多个素因子乘积的形式，并按素因子的大小排列显示出来。大家对计算器中数的表示应该很清楚的。下面显示出了0 — 9这十个数字的表示形式。每个数字都占据5 * 3大小的字符区域你能实现这个新功能吗？试试看吧！<br/>
<img src="http://bj.bcebos.com/v1/acmcoder/2872251999649310.png?authorization=bce-auth-v1%2F02fe1db0eea94e8480054b43acd6124f%2F2016-06-20T07%3A10%3A11Z%2F-1%2F%2Fde80d2cde57b29c254d50767649e10b8039cc670da78dd7c5780b6afc796931c" width="500" height="100"/>

### 2. ZigZag Conversion
**Problem Description:** The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
> P　 　A 　 　H　　N<br>
> A　P　L　S　I　I　G<br>
> Y 　 　I 　 　R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

### 3. BadNeighbor
**Problem Description:** <br/>
The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken those words to heart. Every resident hates his next-door neighbors on both sides. Nobody is willing to live farther away from the town's well than his neighbors, so the town has been arranged in a big circle around the well. Unfortunately, the town's well is in disrepair and needs to be restored. You have been hired to collect donations for the Save Our Well fund.

Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations, which is listed in clockwise order around the well. However, nobody is willing to contribute to a fund to which his neighbor has also contributed. Next-door neighbors are always listed consecutively in donations, except that the first and last entries in donations are also for next-door neighbors. You must calculate and return the maximum amount of donations that can be collected.

 
Definition
    	
Class:	BadNeighbors
Method:	maxDonations
Parameters:	int[]
Returns:	int
Method signature:	int maxDonations(int[] donations)
(be sure your method is public)
    
  
Constraints
-	donations contains between 2 and 40 elements, inclusive.
-	Each element in donations is between 1 and 1000, inclusive.
 
Examples
> 0)<br>	{ 10, 3, 2, 5, 7, 8 }
Returns: 19<br>
The maximum donation is 19, achieved by 10+2+7. It would be better to take 10+5+8 except that the 10 and 8 donations are from neighbors.<br><br>
> 1)<br>{ 11, 15 }
Returns: 15<br><br>
> 2)<br>{ 7, 7, 7, 7, 7, 7, 7 }
Returns: 21<br><br>
>3)	<br>{ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }
Returns: 16<br><br>
> 4)<br>{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, <br> 
  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,<br>
  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }
Returns: 2926

### 4. Max SubArray
Find the contiguous subarray within an array
 (containing at least one number) which has the largest sum.
 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

### 5. Regular Expressing Matching
Implement regular expression matching with support for '.' and '*'.
> '.' Matches any single character.<br>
> '\*' Matches zero or more of the preceding element.<br><br>
> The matching should cover the entire input string (not partial).<br><br>
> The function prototype should be:<br>
> bool isMatch(const char *s, const char *p)<br><br>
Some examples:<br>
isMatch("aa","a") → false<br>
isMatch("aa","aa") → true<br>
isMatch("aaa","aa") → false<br>
isMatch("aa", "a*") → true<br>
isMatch("aa", ".*") → true<br>
isMatch("ab", ".*") → true<br>
isMatch("aab", "c*a*b") → true