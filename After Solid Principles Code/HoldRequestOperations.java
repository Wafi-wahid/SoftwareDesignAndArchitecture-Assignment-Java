package LMS;

import java.util.ArrayList;

public class HoldRequestOperations {
    private ArrayList<HoldRequest> holdRequests; // No static field

    public HoldRequestOperations() {
        this.holdRequests = new ArrayList<>();
    }

    public void addHoldRequest(HoldRequest hr) {
        holdRequests.add(hr);
    }

    public void removeHoldRequest() {
        if (!holdRequests.isEmpty()) {
            holdRequests.remove(0);
        }
    }

    public ArrayList<HoldRequest> getHoldRequests() {
        return holdRequests;
    }
}

