/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.mce.minigames.impl.test.nms;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;

import com.github.mce.minigames.api.MinigameInterface;
import com.github.mce.minigames.api.arena.ArenaInterface;
import com.github.mce.minigames.api.event.ArenaPlayerJoinEvent;
import com.github.mce.minigames.api.player.ArenaPlayerInterface;
import com.github.mce.minigames.impl.nms.MgArenaPlayerJoinEvent;

/**
 * Test for {@link MgArenaPlayerJoinEvent}
 * 
 * @author mepeisen
 *
 */
public class MgArenaPlayerJoinEventTest
{
    
    /**
     * Tests constructor
     */
    @Test
    public void testConstructor()
    {
        final ArenaInterface arena = mock(ArenaInterface.class);
        final MinigameInterface minigame = mock(MinigameInterface.class);
        when(arena.getMinigame()).thenReturn(minigame);
        final ArenaPlayerInterface player = mock(ArenaPlayerInterface.class);
        final ArenaPlayerJoinEvent evt = new ArenaPlayerJoinEvent(arena, player);
        final MgArenaPlayerJoinEvent mgevt = new MgArenaPlayerJoinEvent(evt);
        
        assertEquals(evt, mgevt.getBukkitEvent());
        assertEquals(arena, mgevt.getArena());
        assertEquals(minigame, mgevt.getMinigame());
        assertEquals(player, mgevt.getPlayer());
    }
    
}