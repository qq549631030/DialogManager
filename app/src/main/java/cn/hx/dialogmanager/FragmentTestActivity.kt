package cn.hx.dialogmanager

import android.os.Bundle
import android.widget.Toast
import cn.hx.prioritydialog.PriorityDialog

class FragmentTestActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
                .add(R.id.container, TestFragment()).commit()
    }

    override fun onCancel(priorityDialog: PriorityDialog) {
        if (priorityDialog.uuid == "onCancel_test_uuid") {
            Toast.makeText(this, "onCancel called", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDismiss(priorityDialog: PriorityDialog) {
        if (priorityDialog.uuid == "onDismiss_test_uuid") {
            Toast.makeText(this, "onDismiss called", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDialogEvent(priorityDialog: PriorityDialog, event: Any) {
        if (priorityDialog.uuid == "onDialogEvent_test_uuid") {
            when (event) {
                is BaseAlertDialog.AlertDialogClickEvent -> {
                    Toast.makeText(this, "button ${event.which} clicked", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }
    }
}