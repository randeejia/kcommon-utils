package io.github.randee.common.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class DeviceInfo {

    @Test
    fun `test 3rd element`() {
        assertEquals(7, generateFibi().take(3).last())
    }
}