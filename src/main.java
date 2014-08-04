
public class main {
	public static void main(String[] args) {
		new Map();
	}
}

//Map -> rom & cor
//rom -> Tiles

class Map{
	int start = 0;
	Rom[] rom = new Rom[3];
	Corridor[] cor = new Corridor[2];
	String[] type = {"Stairs", "Ladder", "Corridor"};
	
	Map(){
		rom[0] = new Rom(this, start);
		cor[0] = new Corridor(this, 0);
		rom[1] = new Rom(this, start);
		cor[1] = new Corridor(this, 1);
		rom[2] = new Rom(this, start);
		rom[2].print();
	}
}
class Corridor{
	
	Corridor(Map map, int nr){

		double random = Math.random();
		
		if(random < 0.3){//trapp
			map.start = 0;
			int y = (int) (Math.random()*map.rom[nr].height);
			int x = (int)(Math.random()*map.rom[nr].width);
			map.rom[nr].map[y][x].type = 8;
			if(random < 0.1){
				
			}else if(random < 0.2){
				if(x+1 < map.rom[nr].width){
					map.rom[nr].map[y][x+1].type = 8;
				}else{
					map.rom[nr].map[y][x-1].type = 8;
				}
			}else{
				if(y+1 < map.rom[nr].height){
					map.rom[nr].map[y+1][x].type = 8;
				}else{
					map.rom[nr].map[y-1][x].type = 8;
				}
				
				if(x+1 < map.rom[nr].width){
					map.rom[nr].map[y][x+1].type = 8;
				}else{
					map.rom[nr].map[y][x-1].type = 8;
				}
				
				if(x+1 < map.rom[nr].width && y+1 < map.rom[nr].height){
					map.rom[nr].map[y+1][x+1].type = 8;
				}else if(x+1 > map.rom[nr].width && y+1 > map.rom[nr].height){
					map.rom[nr].map[y-1][x-1].type = 8;
				}else if(x+1 > map.rom[nr].width && y+1 < map.rom[nr].height){
					map.rom[nr].map[y+1][x-1].type = 8;
				}else if(x+1 < map.rom[nr].width && y+1 > map.rom[nr].height){
					map.rom[nr].map[y-1][x+1].type = 8;
				}
			}
			map.rom[nr].print();
			System.out.println();
			System.out.println();
			
		}else if(random < 0.6){//stige
			map.start = 0;
			map.rom[nr].map[(int) (Math.random()*map.rom[nr].height)][(int)(Math.random()*map.rom[nr].width)].type = 7;
			map.rom[nr].print();
			System.out.println();
			System.out.println();
			
		}else{//Korridor
			map.rom[nr].print();
			int start = (int)(Math.random()*(map.rom[nr].width-1))+map.start;
			if(random < 0.8){
				for(int m = 0; m < (int)(Math.random()*5)+1; m++){
					for(int n = 0; n < start; n++){
						System.out.print("- ");
					}
					System.out.print("0 ");
					
					for(int n = start+1; n < map.rom[nr].width; n++){
						System.out.print("- ");
					}
					System.out.println();
					
				}
			}else{
				for(int m = 0; m < (int)(Math.random()*5)+1; m++){
					for(int n = 0; n < start-1; n++){
						System.out.print("- ");
					}
					System.out.print("0 ");
					System.out.print("0 ");
					
					for(int n = start+2; n < map.rom[nr].width; n++){
						System.out.print("- ");
					}
					System.out.println();
				}
			}
			map.start = start;
		}
	}
}

class Rom{
	int height, width;
	int start;
	Tile[][] map;
	String[] type = {"Floor", "Trip Wire", "Pit fall", "Snare", "Chair", "Table", "Lever", "Ladder", "Stairs"};
	Map ma;
	
	Rom(Map ma, int start){
		this.ma = ma;
		if(start < width){
			this.start = (int)(Math.random()*start);
		}else{
			this.start = start-(int)(Math.random()*(width-1))-1;
		}
		height = (int) (Math.random()*6)+3;
		width = (int) (Math.random()*5)+3;
		map = new Tile[height][width];
		
		for(int n = 0; n < height; n++){
			for(int m = 0; m < width; m++){
				if(Math.random()<0.1){
					map[n][m] = new Tile((int) (Math.random()*6)+1);
				}else{
					map[n][m] = new Tile(0);
				}
			}
		}
		ma.start = start;
	}
	
	public void print(){
		for(int n = 0; n < height; n++){
			for(int s = 0; s < start; s++){
				System.out.print("- ");
			}
			for(int m = 0; m < width; m++){
				System.out.print(map[n][m].type + " ");
			}
			System.out.println();
		}
	}
}

class Tile{
	int type;
	
	Tile(int type){
		this.type = type;
	}
}


class Type{
	//img
	int prob;
	String name;
}