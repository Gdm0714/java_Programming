import java.util.*;

class Polynomial {
	int degree;
	double[] coef;

	public Polynomial() {
	};

	public Polynomial(int degree, double[] coef) {
		this.degree = degree;
		this.coef = coef;
	}

	public void add_poly(Polynomial A, Polynomial B, Polynomial ret) {
		int Apos = 0, Bpos = 0, Retpos = 0;
		int degree_a = A.degree;
		int degree_b = B.degree;
		ret.degree = ((A.degree > B.degree) ? A.degree : B.degree);
		while (Apos <= A.degree && Bpos <= B.degree) {
			if (degree_a > degree_b) {
				ret.coef[Retpos++] = A.coef[Apos++];
				degree_a--;
			} else if (degree_a == degree_b) {
				ret.coef[Retpos++] = A.coef[Apos++] + B.coef[Bpos++];
				degree_a--;
				degree_b--;
			} else {
				ret.coef[Retpos++] = B.coef[Bpos++];
				degree_b--;
			}
		}
	}

	public void sub_poly(Polynomial A, Polynomial B, Polynomial ret) {
		int Apos = 0, Bpos = 0, Retpos = 0;
		int degree_a = A.degree;
		int degree_b = B.degree;
		ret.degree = ((A.degree > B.degree) ? A.degree : B.degree);
		while (Apos <= A.degree && Bpos <= B.degree) {
			if (degree_a > degree_b) {
				ret.coef[Retpos++] = A.coef[Apos++];
				degree_a--;
			} else if (degree_a == degree_b) {
				ret.coef[Retpos++] = A.coef[Apos++] - B.coef[Bpos++];
				degree_a--;
				degree_b--;
			} else {
				ret.coef[Retpos++] = B.coef[Bpos++];
				degree_b--;
			}
		}
	}

	public void mult_poly(Polynomial A, Polynomial B, Polynomial ret) {
		ret.degree = A.degree + B.degree;
		for (int i = 0; i <= A.degree; i++) {
			for (int j = 0; j <= B.degree; j++) {
				ret.coef[i + j] += (A.coef[i] * B.coef[j]);
			}

		}
	}

	public void div_poly(Polynomial A, Polynomial B, Polynomial ret1, Polynomial ret2) {
		int Apos = 0, Bpos = 0, Retpos = 0, Retpos2 = 0;
		int num = 0;
		int degree_a = A.degree;
		int degree_b = B.degree;
		ret1.degree = A.degree - B.degree;
		ret2.degree = B.degree - 1;
		while (degree_a >= degree_b) {
			ret1.coef[Retpos] = A.coef[Apos++] / B.coef[Bpos];
			for (int i = 0; i <= B.degree; i++) {
				A.coef[i + num] -= ret1.coef[Retpos] * B.coef[i];
			}
			num++;
			degree_a--;
			Retpos++;
		}
		for (int i = 0; i <= A.degree; i++) {
			if (A.coef[i] > 0) {
				ret2.coef[Retpos2++] = A.coef[i];
			}
		}
	}

	public void print_polynomial(Polynomial _in) {
		for (int i = _in.degree; i > 0; i--) {
			System.out.print(_in.coef[_in.degree - i] + "x^" + i + " + ");
		}
		System.out.println(_in.coef[_in.degree]);
	}
}

public class Poly {
	public static void main(String[] args) {
		double[] coef1 = { 2, -1, 1, 3 };
		double[] coef2 = { 2, 1 };
		double[] coef3 = { 1, 3, 4 };
		double[] coef4 = { 1, -1 };
		double[] coef5 = { 6, 8, 5 };
		double[] coef6 = { 1, 1 };
		double[] result = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] result2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Polynomial A = new Polynomial(3, coef1);
		Polynomial B = new Polynomial(1, coef2);
		Polynomial C = new Polynomial(2, coef3);
		Polynomial D = new Polynomial(1, coef4);
		Polynomial E = new Polynomial(2, coef5);
		Polynomial F = new Polynomial(1, coef6);
		System.out.println("1) ÀÔ·ÂµÈ ´ÙÇ×½Ä");
		System.out.print("A:");
		A.print_polynomial(A);
		System.out.print("B:");
		B.print_polynomial(B);
		Polynomial add = new Polynomial(100, result);
		add.add_poly(A, B, add);
		System.out.print("µ¡¼À °á°ú: ");
		add.print_polynomial(add);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial sub = new Polynomial(100, result);
		sub.sub_poly(A, B, sub);
		System.out.print("»¬¼À °á°ú: ");
		sub.print_polynomial(sub);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial mul = new Polynomial(100, result);
		mul.mult_poly(A, B, mul);
		System.out.print("°ö¼À °á°ú: ");
		mul.print_polynomial(mul);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial div = new Polynomial(100, result);
		Polynomial div2 = new Polynomial(100, result2);
		div.div_poly(A, B, div, div2);
		System.out.print("³ª´°¼À ¸ò: ");
		div.print_polynomial(div);
		System.out.print("³ª´°¼À ³ª¸ÓÁö:");
		div2.print_polynomial(div2);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		for (int i = 0; i < result2.length; i++)
			result2[i] = 0;

		System.out.println("2) ÀÔ·ÂµÈ ´ÙÇ×½Ä");
		System.out.print("A:");
		C.print_polynomial(C);
		System.out.print("B:");
		D.print_polynomial(D);
		Polynomial add2 = new Polynomial(100, result);
		add2.add_poly(C, D, add2);
		System.out.print("µ¡¼À °á°ú: ");
		add2.print_polynomial(add2);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial sub2 = new Polynomial(100, result);
		sub2.sub_poly(C, D, sub2);
		System.out.print("»¬¼À °á°ú: ");
		sub2.print_polynomial(sub2);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial mul2 = new Polynomial(100, result);
		mul2.mult_poly(C, D, mul2);
		System.out.print("°ö¼À °á°ú: ");
		mul2.print_polynomial(mul2);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial div3 = new Polynomial(100, result);
		Polynomial div4 = new Polynomial(100, result2);
		div3.div_poly(C, D, div3, div4);
		System.out.print("³ª´°¼À ¸ò: ");
		div3.print_polynomial(div3);
		System.out.print("³ª´°¼À ³ª¸ÓÁö:");
		div4.print_polynomial(div4);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		for (int i = 0; i < result2.length; i++)
			result2[i] = 0;
		
		System.out.println("3) ÀÔ·ÂµÈ ´ÙÇ×½Ä");
		System.out.print("A:");
		E.print_polynomial(E);
		System.out.print("B:");
		F.print_polynomial(F);
		Polynomial add3 = new Polynomial(100, result);
		add3.add_poly(E, F, add3);
		System.out.print("µ¡¼À °á°ú: ");
		add3.print_polynomial(add3);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial sub3 = new Polynomial(100, result);
		sub3.sub_poly(E, F, sub3);
		System.out.print("»¬¼À °á°ú: ");
		sub3.print_polynomial(sub3);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial mul3 = new Polynomial(100, result);
		mul3.mult_poly(E, F, mul3);
		System.out.print("°ö¼À °á°ú: ");
		mul3.print_polynomial(mul3);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		Polynomial div5 = new Polynomial(100, result);
		Polynomial div6 = new Polynomial(100, result2);
		div5.div_poly(E, F, div5, div6);
		System.out.print("³ª´°¼À ¸ò: ");
		div5.print_polynomial(div5);
		System.out.print("³ª´°¼À ³ª¸ÓÁö:");
		div6.print_polynomial(div6);
		for (int i = 0; i < result.length; i++)
			result[i] = 0;
		for (int i = 0; i < result2.length; i++)
			result2[i] = 0;
	}
}
