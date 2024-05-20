package dataprovider_with_xlfile;

public class Pattern {

	public static void main(String[] args) {
		Pattern pt=new Pattern();
		pt.Square_Fill_Pattern(6);
		Square_Hollow_Pattern(6);
		Number_increasing_Pyramid_Pattern(6);
		Number_increasing_reverse_Pyramid_Pattern(4);
		Number_triangle_Pattern(4);
		Number_changing_Pyramid_Pattern(4);
		Zero_One_Triangle_Pattern(4);
		Rhombus_Pattern(4);
	}
	public  void Square_Fill_Pattern(int count) {
		for(int i=1;i<=count;i++) {
			for(int j=1;j<=count;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void Square_Hollow_Pattern(int count) {
		for(int i=1;i<=count;i++) {
			for(int j=1;j<=count;j++) {
				if(i==1||i==count||j==1||j==count) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void Number_increasing_Pyramid_Pattern (int count) {
		for(int i=1;i<=count;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public static void Number_increasing_reverse_Pyramid_Pattern(int count) {
		for(int i=count;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public static void Number_triangle_Pattern(int count) {
		for(int i=1;i<=count;i++) {
			for(int j=1;j<=count-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static void Number_changing_Pyramid_Pattern(int count) {
		int i,j,num=1;
		
		for(i=1;i<=count;i++) {
			for(j=1;j<=i;j++) {
				System.out.print(num+" ");
				num++;
			}
			System.out.println();
		}
	}
	public static void Zero_One_Triangle_Pattern(int count) {
		int i,j;
		for(i=1;i<=count;i++) {
			for(j=1;j<=i;j++) {
				if(j%2==0) {
					System.out.print(0+" ");
				}
				else System.out.print(1+" ");
			}
			System.out.println();
		}
	}
	public static void Rhombus_Pattern(int count) {
		int i,j;
		for(i=0;i<=count;i++) {
			for(j=0;j<count-i;j++) {
				System.out.print(" ");
			}
			for(j=0;j<count;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
