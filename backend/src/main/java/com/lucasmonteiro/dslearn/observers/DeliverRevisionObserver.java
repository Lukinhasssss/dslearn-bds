package com.lucasmonteiro.dslearn.observers;

import com.lucasmonteiro.dslearn.entities.Deliver;

public interface DeliverRevisionObserver {
	
	void onSaveRevision(Deliver deliver);

}
