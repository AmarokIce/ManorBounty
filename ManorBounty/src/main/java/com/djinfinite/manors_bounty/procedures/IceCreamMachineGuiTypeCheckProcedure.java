package com.djinfinite.manors_bounty.procedures;

import net.minecraft.client.gui.components.Checkbox;

import java.util.HashMap;

public class IceCreamMachineGuiTypeCheckProcedure {
	public static boolean execute(HashMap guistate) {
		if (guistate == null)
			return false;
		return !(guistate.containsKey("checkbox:IceCreamTypeCheck") && ((Checkbox) guistate.get("checkbox:IceCreamTypeCheck")).selected());
	}
}
