package Medium;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {

    public static long dividePlayers(int[] skill) {
        int len = skill.length;
        if(skill.length == 2) return (long) skill[0] * skill[1];

        Arrays.sort(skill);

        long res = skill[0] + skill[len - 1];
        long totalChemistry = 0;

        for(int i = 0; i < len / 2; i++) {
            if(skill[i] + skill[len - i - 1] != res) return -1;
            totalChemistry += (long) skill[i] * skill[len - i - 1];
        }

        return totalChemistry;
    }

    public static void main(String[] args) {
        int[] skill = {3, 2, 5, 1, 3, 4};

        System.out.println(dividePlayers(skill));
    }
}
