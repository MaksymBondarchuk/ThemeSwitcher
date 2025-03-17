package bss.themeswitcher

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ThemeSwitcherAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        ThemeSwitcherUtil.switchTheme()
    }
}