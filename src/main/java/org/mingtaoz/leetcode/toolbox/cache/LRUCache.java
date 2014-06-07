package org.mingtaoz.leetcode.toolbox.cache;

import java.util.Map;

import org.mingtaoz.leetcode.list.DoublyLinkedList;
import org.mingtaoz.leetcode.list.DoublyLinkedList.Node;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 */
public class LRUCache {

	private int capacity;
	private Map<Integer, Node> cache;
	private DoublyLinkedList usageList;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			// move to head
			usageList.remove(cache.get(key));
			usageList.addToFront(cache.get(key));
			return cache.get(key).value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (cache.containsKey(key)) {
			// no grow
			usageList.remove(cache.get(key));
			usageList.addToFront(cache.get(key));
		} else {
			if (cache.size() == capacity) {
				// case 1 full
				usageList.removeTail();
			}
			Node newNode = new Node(key, value);
			usageList.addToFront(newNode);
			cache.put(key, newNode);
		}
	}
}
