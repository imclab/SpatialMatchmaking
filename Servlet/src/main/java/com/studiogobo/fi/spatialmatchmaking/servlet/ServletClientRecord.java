package com.studiogobo.fi.spatialmatchmaking.servlet;

import com.studiogobo.fi.spatialmatchmaking.model.ClientRecord;

import java.util.concurrent.CountDownLatch;

public class ServletClientRecord extends Timestamped
{
    public ClientRecord clientRecord;
    public int match_id = 0;
    public boolean deleted = false;
    public boolean active = false;
    public CountDownLatch waitUntilMatched = new CountDownLatch(1);

    public ServletClientRecord(ClientRecord _clientRecord)
    {
        clientRecord = _clientRecord;
    }

    public void ClearMatch()
    {
        // Avoid reallocating the latch if we are not already matched.  We don't want to forget
        // the old latch leaving any threads in a locked state.  So we only proceed if we are
        // matched (in which case, the latch will be unlocked already).
        if (match_id != 0)
        {
            match_id = 0;
            waitUntilMatched = new CountDownLatch(1);
        }
    }

    public boolean RequirementsPass(ServletClientRecord other)
    {
        return clientRecord.RequirementsPass(other.clientRecord);
    }
}
