package com.abc;

import java.util.Scanner;
public class Percolation {
	private boolean[][] sites;
	private int grid;
	private int beginNode;
	private int endNode;

	private WeightedQuickUnionUF QU;
	private WeightedQuickUnionUF Backwash;

	// private QuickFindUF QU;
	public Percolation(int N) {
		N = N + 1;
		QU = new WeightedQuickUnionUF(N * N + 1); // +2 for the top and bottom node
		Backwash = new WeightedQuickUnionUF(N * N + 2);
		// QU = new QuickFindUF(N*N+2);
		sites = new boolean[N][N]; // create N-by-N grid, with all sites blocked
		grid = N - 1;
		beginNode = 0;
		endNode = N * N + 1;

	}

	public void open(int i, int j) {
		// open site (row i, column j) if it is not already
		// check if out of bound:

		checkException(i, j);
		if (!sites[j][i]) {
			sites[j][i] = true;
		}
		int index = indexCalc(j, i);
		// Connect the site with surrounding nodes
		// left:
		if (j != 1) {
			if (sites[j - 1][i]) {
				QU.union(index, index - 1);
				Backwash.union(index, index - 1);
			}
		}
		// right:
		if (j != grid) {
			if (sites[j + 1][i]) {
				QU.union(index, index + 1);
				Backwash.union(index, index + 1);
			}
		}
		// top:
		if (i != 1) {
			if (sites[j][i - 1]) {
				QU.union(index, j + grid * (i - 1));
				Backwash.union(index, j + grid * (i - 1));
			}
		} else {
			QU.union(beginNode, index); // connect with top node which we will just have as N^2
			Backwash.union(beginNode, index);
		}
		// bottom:

		if (i != grid) {
			if (sites[j][i + 1]) {
				QU.union(index, j + grid * (i + 1));
				Backwash.union(index, j + grid * (i + 1));
			}
		} else {
			Backwash.union(index, endNode);
		}

	}

	public boolean isOpen(int i, int j) {

		checkException(i, j);
		// is site (row i, column j) open?
		return sites[j][i];
	}

	public boolean isFull(int i, int j) {

		checkException(i, j);
		// is site (row i, column j) full?
		return (QU.connected(indexCalc(j, i), beginNode));
	}

	public boolean percolates() {
		return Backwash.connected(beginNode, endNode);
	}

	private int indexCalc(int i, int j) {
		return i + grid * j;
	}

	private void checkException(int i, int j) {
		if (i <= 0 || i > grid || j <= 0 || j > grid) {
			throw new IndexOutOfBoundsException("row index i out of bounds");
		}
	}

}
public class WeightedQuickUnionUF {
	private int[] id; // id[i] = parent of i
	private int[] sz; // sz[i] = number of objects in subtree rooted at i
	private int count; // number of components

	// Create an empty union find data structure with N isolated sets.
	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	// Return the number of disjoint sets.
	public int count() {
		return count;
	}

	// Return component identifier for component containing p
	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	// Are objects p and q in the same set?
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	// Replace sets containing p and q with their union.
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;

		// make smaller root point to larger one
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

}


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter input");
		int grid_size = sc.nextInt(); 
		Percolation perc = new Percolation(grid_size);
		
		while(sc.hasNext() ) 
		{
			int p = sc.nextInt();
			int q = sc.nextInt();
			perc.open(p, q);
		}
		System.out.println(perc.percolates());

	}

}
