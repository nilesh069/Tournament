package assignment.main;

import java.io.Console;
import java.util.*;


import javax.swing.event.CellEditorListener;


public class Tournament {

	public static void main(String[] args) {
			System.out.println("Enter No Of Team");
			
			int noOfTeam=0;
			Queue<Teams> teamList = new LinkedList<>();
			/*if Try to get input from User At Run Time  
			 * 
			 * 
			 * Scanner scaner=new Scanner(System.in);
			noOfTeam=scaner.nextInt();
			System.out.println("No Of Team is : "+noOfTeam);
			Teams team1=null;
			for(int i=0;i<noOfTeam;i++){
				team1=new Teams();
				System.out.println("Enter "+i+" Team rank");
				team1.setRank(scaner.nextInt());	
				System.out.println("Enter "+i+" Team name");
				team1.setName(scaner.next());	
				team1.setRound(1);
				teamList.offer(team1);
				team1=null;
			}
			*/
		/*   ------->HardCodec Version<------   */
			noOfTeam=4;
		Teams team1=new Teams(1, "India", 1, 1);
		Teams team2=new Teams(2, "Pakistan", 1, 1);
		Teams team3=new Teams(3, "Srilanka", 1, 1);
		Teams team4=new Teams(4, "Bangladesh", 1, 1);
		teamList.offer(team1);
		teamList.offer(team2);
		teamList.offer(team3);
		teamList.offer(team4);
		
		
		
		if(checkPowerOfTwo(noOfTeam)){
			int round=1;
			while(teamList.size()>=2){
				System.out.println("Tournament Round No : "+round);
				Teams t1=teamList.poll();
				Teams t2=teamList.poll();
				Teams t3=playMatch(t1, t2);
				teamList.add(t3);
				System.out.println("Winner Of Round No : "+round+" Is "+t3.getName());
				round+=1;
			}
			
			if(teamList.size()==1){
				System.out.println("Winner Of Turnament is : "+teamList.poll().toString());
			}
			
			
		}else{
			System.out.println("Not Valid Team Size For Tournament..("+noOfTeam+")");
		}
		
	}
private static boolean checkPowerOfTwo(int number){
	if(number<=1)return false;
	else{
		while(number>1){
			if(number%2==1)return false;
			number=number/2;
		}
		return true;
	}
}
private static Teams playMatch(Teams t1,Teams t2){
	System.out.println("Match between "+t1.getName()+ " And "+t2.getName());
	Random rand=new Random();
	Teams winner=(rand.nextBoolean())?t1:t2;
	winner.setRound(winner.getRound()+1);
	return winner;
}
private static class Teams {
	
	private int rank;
	private String name;
	private int round=1;
	private int result;
	private String resultDescription;
	
	public Teams(){}
	public Teams(int rank,String name,int round,int result){
		this.rank=rank;
		this.name=name;
		this.round=round;
		this.setResult(result);
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
		this.setResultDescription((result==1)?"Winer":"Loser");
	}
	private String getResultDescription() {
		return resultDescription;
	}
	private void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	@Override
	public String toString() {
		return "Teams [rank=" + rank + ", name=" + name + ", round=" + round + ", result=" + result
				+ ", resultDescription=" + resultDescription + "]";
	}
}
}
