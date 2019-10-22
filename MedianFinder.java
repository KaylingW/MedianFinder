//295. Find Median from Data Stream
//Time Complexity: O(log n). Finding mean: O(1)

class MedianFinder {
    // use Heaps. Priority-Queue
    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public MedianFinder() {
        // minHeap on right side of the tree (higher), maxHeap on the left (lower).
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // Sort elements in opposite order

    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll()); // Pop and add the element from the minHeap to maxHeap

        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll()); // If the size of the minHeap is less than the maxHeap, pop out element from
                                           // maxHeap and offer it to the minHeap
        }
    }

    public double findMedian() {

        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek(); // Retrieve head of minHeap queue
        } else {
            // Return median by taking head of min and max Heap and divide that by two to
            // get the average
            return (((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0);
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */