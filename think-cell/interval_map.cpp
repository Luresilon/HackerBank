#include <iomanip>
#include <iostream>
#include <map>

template<typename K, typename V>
class interval_map {
    friend void IntervalMapTest();
    V m_valBegin;
    std::map<K, V> m_map;

public:
    // constructor associates whole range of K with val
    interval_map(V const& val)
        : m_valBegin(val)
    {}

    // Assign value val to interval [keyBegin, keyEnd).
    // Overwrite previous values in this interval.
    // Conforming to the C++ Standard Library conventions, the interval
    // includes keyBegin, but excludes keyEnd.
    // If !( keyBegin < keyEnd ), this designates an empty interval,
    // and assign must do nothing.

    void assign(K const& keyBegin, K const& keyEnd, V const& val) {
        // Do nothing for empty interval
		if (!(keyBegin < keyEnd))
			return;

		// Find iterators to the bounds
		auto itLow = m_map.upper_bound(keyBegin);
		auto itHigh = m_map.upper_bound(keyEnd);

		// Determine the value at keyBegin
		V valBefore = (itLow == m_map.begin()) ? m_valBegin : std::prev(itLow)->second;

		// Adjust the map at keyBegin
		if (valBefore != val) {
			if (itLow != m_map.end() && itLow->first == keyBegin)
				itLow->second = val;
			else
				itLow = m_map.insert_or_assign(itLow, keyBegin, val);
		}

		// Adjust the map at keyEnd
		V valAfter = (itHigh == m_map.begin()) ? m_valBegin : std::prev(itHigh)->second;
		if (valAfter != val) {
			itHigh = m_map.insert_or_assign(itHigh, keyEnd, valAfter);
		}

		// Remove elements in the range (keyBegin, keyEnd)
		m_map.erase(std::next(itLow), itHigh);
		
		// Ensure canonicity by removing unnecessary entries
		if (itLow != m_map.begin() && std::prev(itLow)->second == itLow->second)
			m_map.erase(itLow);
		if (itHigh != m_map.end() && std::prev(itHigh)->second == itHigh->second)
			m_map.erase(itHigh);

        V valAfter = (itLow == m.map.begin()) ? m_valAfter : std::prev(itlow)->second;
    }

    // look-up of the value associated with key
    V const& operator[](K const& key) const {
        auto it = m_map.upper_bound(key);
        if (it == m_map.begin()) {
            return m_valBegin;
        } else {
            return std::prev(it)->second;
        }
    }
};

void IntervalMapTest() {
    interval_map<int, char> m('A');

    // Test 1: Basic assignments
    m.assign(1, 3, 'B');
    m.assign(5, 7, 'C');
    std::cout << "Test 1: Basic assignments\n";
    for (int i = -1; i <= 8; ++i)
        std::cout << std::setw(2) << i << ' ' << m[i] << '\n';

    // Test 2: Overlapping intervals
    m.assign(2, 6, 'D');
    std::cout << "Test 2: Overlapping intervals\n";
    for (int i = -1; i <= 8; ++i)
        std::cout << std::setw(2) << i << ' ' << m[i] << '\n';

    // Test 3: Non-overlapping intervals
    m.assign(8, 10, 'E');
    std::cout << "Test 3: Non-overlapping intervals\n";
    for (int i = -1; i <= 11; ++i)
        std::cout << std::setw(2) << i << ' ' << m[i] << '\n';

    // Test 4: Edge cases
    m.assign(4, 4, 'F');  // Empty interval
    m.assign(10, 15, 'G');
    std::cout << "Test 4: Edge cases\n";
    for (int i = -1; i <= 16; ++i)
        std::cout << std::setw(2) << i << ' ' << m[i] << '\n';
}

// Example usage
int main() {

    IntervalMapTest();
    return 0;
}
