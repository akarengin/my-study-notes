package hackerrank;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import linkedlist.Node;

public class Problems {

    public static void main(String[] args) throws ParseException {
        //System.out.println(reverse(102, ""));
        //System.out.println(beautifulDays(20, 23, 6));

        //System.out.println("CutTheSticks2: " + cutTheSticks1(List.of(8, 8, 14, 10, 3, 5, 14, 12)));

/*        for (int i=10; i<100; i++)
            if (kaprekar(i))
                System.out.print(i + " ");*/

        //printModifiedKaprekarNumberss(1, 100);

        //kaprekarNumbers(1,100);

        //System.out.println(getTotalX(Stream.of(1).collect(Collectors.toList()), Stream.of(72, 48).collect(Collectors.toList())));

        //System.out.print(howManyGames(93, 39, 74, 9553));

        //System.out.println(acmTeam(List.of("10101", "11100", "11010", "00101")));

        //System.out.println(beautifulTripletss(1, List.of(2, 2, 3, 4, 5)));

        //System.out.println(minimumDistances(List.of(20,760,143,550,365,559,539,299,160,955,706,462,329,786,989,867,47,648,171,369,625,975,538,532,973,25,515,395,724,487,618,745,247,113,647,612,24,186,263,537,493,321,999,174,108,988,394,507,988,917,228,613,892,118,497,218,144,13,613,220,500,583,965,748,49,613,712,73,151,976,610,997,297,961,171,757,949,565,616,937,483,844,903,727,963,400,945,459,765,910,31,266,494,997,366,895,962,78,968,465,406,931,814,56,892,338,813,194,255,782,483,90,626,386,818,941,139,115,752,904,26,784,522,872,133,888,767,447,967,87,264,725,370,79,781,263,417,947,809,672,729,292,763,355,31,933,649,522,48,401,426,426,537,301,650,670,189,769,469,508,857,734,234,227,813,15,842,582,314,651,606,43,296,721,751,679,654,400,201,55,153,979,481,691,280,484,713,470,253,183,978,462,269,564,690,434,580,884,16,894,536,622,290,184,696,41,863,350,441,64,757,946,395,239,989,676,75,703,498,328,238,828,791,507,393,833,941,325,717,309,571,605,283,861,141,979,902,4,682,695,420,439,642,816,30,631,844,105,686,342,786,276,170,577,135,915,762,428,240,831,737,812,437,373,673,930,352,928,935,34,623,707,826,617,523,856,601,719,314,287,413,100,916,584,677,51,499,791,480,92,622,569,904,411,942,577,342,647,857,629,33,481,336,859,450,212,716,51,931,30,691,345,130,607,281,159,10,132,302,490,224,924,60,480,336,354,410,30,1,267,659,35,100,347,894,551,911,962,602,195,344,293,892,474,252,173,985,263,657,639,105,234,564,165,714,252,872,124,634,873,744,293,908,844,992,803,395,904,765,998,99,462,643,991,936,248,516,274,863,525,913,968,759,829,486,826,81,358,302,67,231,46,360,140,891,705,295,286,609,412,636,60,874,632,403,163,232,919,789,95,796,54,63,556,884,901,734,317,259,36,385,491,83,97,983,326,154,630,964,763,42,953,175,269,585,578,432,817,849,573,264,998,627,327,906,511,229,640,181,840,676,918,683,111,15,666,789,170,648,754,285,43,707,813,312,644,743,96,813,945,669,77,943,296,404,849,160,985,489,693,826,517,611,509,981,978,528,770,148,528,524,786,571,583,951,883,227,694,979,40)));
        //System.out.println(minimumDistances(List.of(454,9087,2397,2541,1459,483,3944,2437,6544,982,8902,576,9336,9672,7742,5982,8461,4640,9236,9248,8333,9742,6718,6213,4368,4553,7815,4666,433,4071,3173,7239,3159,1923,9780,4618,2406,76,3407,5302,1058,2309,2231,6746,8333,9973,2728,3146,965,1964,2394,9299,8058,9112,5512,2426,3666,9680,7093,4099,3751,6618,7690,3262,4893,3823,7880,3651,3899,7640,8954,4958,6301,1185,8056,4635,7510,785,7781,8476,9101,176,7775,7160,9288,9639,9586,9306,9319,3031,3405,9423,6002,7448,2685,895,1271,6918,4547,5170,910,3501,6480,7211,1038,4537,1846,4900,1674,5980,3376,7127,6156,7503,4287,1796,3495,226,1103,2814,3257,860,8589,9259,8308,7627,155,5931,897,1054,1102,1807,4555,3934,9018,1945,4823,7217,6845,6497,3197,6574,3625,5705,4077,4264,7501,7572,4490,4956,6739,4100,5817,1680,3359,477,9307,9866,6409,204,920,3863,8363,1827,4149,7382,124,8973,951,6970,1822,4148,9896,1799,6205,3973,6064,3706,7898,6906,5015,989,1006,832,9021,718,7661,8329,6936,4070,4885,4209,4285,3249,6036,4787,6983,2513,3760,4286,9483,1934,4786,9379,3734,991,9704,6150,1049,3954,9408,6064,1295,6767,3248,317,7485,910,4998,773,1332,9883,4982,1970,9484,7371,6757,2819,9884,517,3457,9367,8803,8243,5098,8889,9234,1154,5039,284,1461,800,2700,2756,7567,5949,9425,1404,6859,4423,2177,8191,659,7160,161,6495,4531,6918,5667,767,3787,9124,6486,8943,7368,1584,7832,2954,9090,2872,9590,551,24,2291,9660,7591,4592,9085,5347,1451,9861,7524,5994,6872,1036,2508,3367,1919,5778,5386,2686,9566,4511,9172,8509,8231,7108,2693,7537,2551,1917,7128,3102,1941,5771,9114,5884,363,8200,1231,8166,4413,5108,4160,1285,2496,3020,1004,4416,8799,6391,3454,4717,7254,8979,9578,1837,2439,2271,5726,4990,4189,2854,4445,6130,4977,3559,2015,1692,8111,3246,9858,2524,4706,371,161,7203,3391,1166,7971,2190,3909,7777,3259,7515,3108,2837,9352,5548,5109,1430,6890,9298,4285,1335,5428,5614,1247,3795,7307,9358,3394,3517,8235,8100,240,8396,5303,3632,5914,9626,2174,6175,7404,5434,3690,512,8271,9394,2412,9732,825,9303,9030,1462,6990,811,3428,8237,4606,735,3948,8000,605,2183,2453,845,6931,4108,829,9198,3735,9356,5373,7491,1142,5416,4355,5765,4810,6768,5498,1987,2423,4528,9801,5765,1691,3230,4003,6298,317,7951,650,922,6486,9455,8120,3417,3564,8949,2615,3651,4657,7989,1142,5799,9757,5497,1565,4567,8617,7063,2907,1040,7943,2708,6806,9635,2290,7161,2285,2608,1464,9287,9882,7950,8743,8002,7719,2307,3304,335,5958,7961,4676,3452,3761,4433,8949,1678,5352,3919,8741,4611,4959,3036,3672,8117,9023,5962,5278,7660,8570,3094,6948,4805,1044,5691,2807,5116,4350,2463,5451,6660,425,6479,112,538,7264,5413,2216,8968,9332,7309,9932,4292,6697,3604,8761,5721,9566,392,3381,4489,3486,329,9294,883,2372,8453,5999,6722,917,7802,3382,7694,633,9846,8232,4249,5260,448,3217,4592,4109,3149,5236,806,3105,350,2879,2672,742,6261,3513,580,2942,2807,1463,1667,1260,3814,4741,8529,1616,4476,6223,8601,4322,4455,2850,5934,1255,2420,527,5364,1921,2115,2523,5027,2465,5402,4051,3207,8015,7564,3788,7310,371,1603,8977,7983,5418,3718,6513,3386,8194,9088,1988,8869,3544,4838,4803,1151,7258,1682,2868,9180,3798,5391,4207,6263,7145,4610,5823,5161,2174,5963,8823,2545,7566,7800,6880,9336,7870,9745,2723,2417,8834,4711,1286,8730,9549,6089,9881,3160,4124,9101,2340,7922,4492,2899,537,7990,7509,6360,9503,9683,8675,8326,8580,2594,2478,1812,1930,348,1558,1005,2765,6744,5716,403,5474,1618,2845,1707,4778,6969,809,3470,4891,1653,2721,5428,5995,6582,8141,5498,2617,3168,176,7549,5762,2654,9361,4045,3003,7271,1402,2120,4015,3471,2524,5841,5089,5369,3901,6219,8690,1062,6041,3581,9067,8762,5361,5063,5344,9854,561,7961,9375,738,5510,1489,9744,1223,5534,2747,8495,3289,1220,8862,6760,3744,4704,1849,5465,4957,4420,4155,6019,461,4088,5086,9223,5801,149,919,5656,7063,5232,5031,4153,7094,6520,3897,8317,8407,6645,3164,1696,7865,2027,4808,7961,6731,3009,9778,8040,7429,285,4059,7890,4373,9145,3465,174,5647,736,2182,2710,2320,7213,6863,9414,86,760,7731,4845,3757,7248,6541,7974,9275,7701,2287,2358,710,2065,398,8139,2350,4457,2381,3075,9954,2198,9602,5601,2934,1784,8311,5254,5350,1526,1020,5436,2287,5103,6633,2396,2351,9526,371,1626,7227,9010,3984,7937,1076,734,6076,9778,1543,4809,2854,1498,7007,2456,7099,6293,592,1763,7899,5942,3289,8919,7730,1928,4022,4363,677,6374,3889,7400,4352,1116,6410,4689,5405,7486,5423,1481,3617,6967,6290,2823,4817,9649,1631,1916,5942,2223,31,3841,4518,9673,9112,8600,7953,3135,9316,8630,5861,3205,6030,6565,674,2441,1254,6079,6279,3030,3913,6248,6349,6555,9071,1166,6205,702,9434,8499,9278,9466,2341,148,5491,7805,8748,3444,940,8064,2075,3153,7622,4457,9719,4648,3250,973,7079,9530,4003,992,2130,352,3900,1202,7870,6457,8256,7305,4956,3886,3123,3649,4034,8614,1455,2783,2058,8747,7199,4133,1901,4821,4943,1620,9469,8193,8945,6549,4075,9301,3893,6206,6005,4145,3760,3876,602,8368,1181,5559,2255,4304,5560,2641,2918,7015,5424,1328,2115,8976,1814,4016,3797,6757,5636,9619,4950,933,2520,5378,234,2765,1584,6240,6911,5344,116,7513,64,7649,9424,2319)));

        //System.out.println(minimumDistances(List.of(10, 1, 3, 4, 1, 7, 1, 3, 4, 1, 7, 1, 7, 1, 3, 4, 1, 7, 1, 7, 1, 3, 4, 1, 5, 1, 220, 220, 1, 3, 4, 1, 7)));

        //System.out.println(chocolateFeastI(6, 2, 2));

        List<Integer> width = List.of(2, 3, 1, 2, 3, 2, 3, 3);
        List<List<Integer>> cases = new ArrayList<>();
        cases.add(List.of(0, 3));
        cases.add(List.of(4, 6));
        cases.add(List.of(6, 7));
        cases.add(List.of(3, 5));
        cases.add(List.of(0, 7));

        //System.out.println(serviceLane(width, cases));

        //System.out.println(workbookss(5, 3, List.of(4, 2, 6, 1, 10)));
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        //System.out.println(fairRationsss(list));

        //System.out.println(gemstones(List.of("abcdde", "baccd", "eeabg")));

        //System.out.println(alternatingCharacters("BBBBB"));

        //System.out.println(gameOfThrones("cdcdcdcdeeeef"));

        //System.out.println(stones(1, 3, 2));

        //plusMinuss(List.of(-4,3,-9,-0,4,1));

        List<Integer> ex = new ArrayList<>();
        ex.add(793810624);
        ex.add(895642170);
        ex.add(685903712);
        ex.add(623789054);
        ex.add(468592370);
        //miniMaxSum(ex);

        //System.out.println(timeConversion("12:00:00AM"));

        //System.out.println(matchingStringss(List.of("aba","baba","aba","xzxb"), List.of("aba","xzxb","ab")));

        List<Integer> myList = new ArrayList<>();
        myList.add(0);
        myList.add(1);
        myList.add(1);
        myList.add(5);
        myList.add(2);
        myList.add(2);
        myList.add(0);
        myList.add(4);
        myList.add(4);
        //System.out.println("lonelyInteger:" + lonelyIntegers(myList));

        //System.out.println(flippingBitss(9));

        List<List<Integer>> diagonalList = new ArrayList<>();
        diagonalList.add(List.of(11, 2, 4));
        diagonalList.add(List.of(4, 5, 6));
        diagonalList.add(List.of(10, 8, -12));

        //System.out.println(diagonalDifference(diagonalList));

        //System.out.println(countingSort(List.of(1,1,3,2,1)));

        //System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));

        List<Integer> A = new ArrayList<>();
        A.addAll(List.of(20, 1));
        List<Integer> B = new ArrayList<>();
        B.addAll(List.of(1, 1));
        //System.out.println(twoArrays(2, A, B));

        //System.out.println(birthdayss(List.of(2, 2, 1, 3, 2), 4, 2));

        List<Integer> findMedian = new ArrayList<>();
        findMedian.add(0);
        findMedian.add(1);
        findMedian.add(2);
        findMedian.add(4);
        findMedian.add(6);
        findMedian.add(5);
        findMedian.add(3);
        //System.out.println(findMedian(findMedian));

        List<List<Integer>> flippingMatrix = new ArrayList<>();
        flippingMatrix.add(List.of(112, 42, 83, 119));
        flippingMatrix.add(List.of(56, 125, 56, 49));
        flippingMatrix.add(List.of(15, 78, 101, 43));
        flippingMatrix.add(List.of(62, 98, 114, 108));
        //System.out.println(flippingMatrix(flippingMatrix));

        //10, 20, 20, 10, 10, 30, 50, 10, 20
        List<Integer> sockMerchant = new ArrayList<>();
        sockMerchant.add(10);
        sockMerchant.add(20);
        sockMerchant.add(20);
        sockMerchant.add(10);
        sockMerchant.add(10);
        sockMerchant.add(30);
        sockMerchant.add(50);
        sockMerchant.add(10);
        sockMerchant.add(20);
        //System.out.println(sockMerchant(9,sockMerchant));

        int[] a = {2, 3, 5, 1, 4};

        //findZigZagSequence(a,5);

        //System.out.println(pageCount(9, 4));

        //System.out.println(towerBreakers(374625, 796723));

        //System.out.println(caesarCiphers("Fqbknx-Qyyp-ys-ymj-Gwnlmy-Xnnj-yk-Qnkj", 5));

        List<Integer> maxMin = new ArrayList<>();
        maxMin.add(100);
        maxMin.add(200);
        maxMin.add(300);
        maxMin.add(350);
        maxMin.add(400);
        maxMin.add(401);
        maxMin.add(402);
        //maxMin.add(40);
        //maxMin.add(100);
        //maxMin.add(200);
        //System.out.println(maxMin(3,maxMin));

        int[] ar = new int[]{-1, -3, 2, -4, 1, 2, 3};
        //System.out.println(solution(ar));

        //System.out.println(solutions("10:00", "13:21"));

        //System.out.println(findParent(5,3));

        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(3);
        lst.add(4);
        lst.add(6);
        lst.add(8);
        lst.add(12);
        // System.out.println(maxSubSet(lst));

        //System.out.println(flippingBitsWithNegation(50));

        int[] arr = new int[]{-3, -1, 2, 1, 3, 4};
        //System.out.println(binarySearch(arr, 1));

        //List<String> grid = Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv");
        List<String> grid = Arrays.asList("abc", "ade", "efg");
        //System.out.println(gridChallenge(grid));

        //System.out.println(balancedSums(List.of(1,2,3)));

        //System.out.println(superDigit("9875", 4));

        //System.out.println(counterGame(6));

        //System.out.println("sumXor: " + sumXor(5));

        //1 2 5 3 7 8 6 4
        List<Integer> q = new ArrayList<>();
        q.add(1);
        q.add(2);
        q.add(5);
        q.add(3);
        q.add(7);
        q.add(8);
        q.add(6);
        q.add(4);
        //minimumBribes(q);

        //System.out.println(isValid("aabbcd"));


        //System.out.println(climbingLeaderboard(List.of(100,90,90,80), List.of(70,80,105)));

        DoublyLinkedListNode root = new DoublyLinkedListNode(1);
        DoublyLinkedListNode node1 = new DoublyLinkedListNode(2);
        root.next = node1;
        node1.prev = root;

        DoublyLinkedListNode node2 = new DoublyLinkedListNode(3);
        node1.next = node2;
        node2.prev = node1;

        //DoublyLinkedListNode resultNode = reverse(root);
        //printDoublyLinkedListForward(resultNode);

        SinglyLinkedListNode headA = new SinglyLinkedListNode(1);
        headA.next = new SinglyLinkedListNode(3);
        headA.next.next = new SinglyLinkedListNode(7);

        SinglyLinkedListNode headB = new SinglyLinkedListNode(1);
        headB.next = new SinglyLinkedListNode(2);

        //printLinkedListForward(mergeLists(headA, headB));

        //System.out.println(icecreamParlors(4, List.of(1, 4, 5, 3, 2)));

        //System.out.println(isBalanced("{(([])[])[]}[]"));

        //System.out.println(waiter(List.of(2,3,4,5,6,7), 3));

        List<Integer> lstt = new ArrayList<>();
        lstt.add(1);
        lstt.add(2);
        lstt.add(3);
        lstt.add(4);

        //System.out.println(pairs(1, lstt));

        List<List<Integer>> petrolPumps = List.of(
                List.of(4, 6),
                List.of(6, 5),
                List.of(7, 3),
                List.of(4, 5)
        );

        //int result = truckTour(petrolPumps);
        //System.out.println(result);

        //System.out.println(legoBlocks(2, 3));

        List<Integer> llst = new ArrayList<>();
        llst.addAll(List.of(1, 2, 3, 9, 10, 12));
        //System.out.println(cookies(7, llst));

        List<Integer> radioList = new ArrayList<>();
        radioList.add(7);
        radioList.add(2);
        radioList.add(4);
        radioList.add(6);
        radioList.add(5);
        radioList.add(9);
        radioList.add(12);
        radioList.add(11);
        // 7 2 4 6 5 9 12 11
        //System.out.println(hackerlandRadioTransmitters(radioList, 2));

        List<Integer> lsttt = new ArrayList<>();
        lsttt.addAll(List.of(2,3,4,5,6));
        //System.out.println(solve(lsttt, List.of(2,3)));

        //System.out.println(arrayManipulation(5, List.of(List.of(1, 2, 100), List.of(2,5,100), List.of(3,4,100))));

        //System.out.println(highestValuePalindrome("932239", 6, 2));

        List<Integer> lilyList = new ArrayList<>();
        lilyList.addAll(List.of(7,15,12,3));
        //System.out.println(lilysHomework(lilyList));

        int height = 3;
        int widht = 4;
        int[] isVertical = {1, 1};
        int[] distance = {1, 3};

        //List<Integer> largestAreas = findLargestRectangles(height, widht, isVertical, distance);
        //System.out.println(largestAreas);

        //System.out.println(anagram("abcffcdegg"));

        //System.out.println(palindromeIndex("aecdfa"));

        permutation("abc");

    }


    public static void printLinkedListForward(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void printDoublyLinkedListForward(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static long beautifulDays(int i, int j, int k) {
        return IntStream.rangeClosed(i, j).map(s -> Math.abs(s - reverse(s, ""))).filter(x -> x % k == 0).count();
    }

    public static int reverse(int number, String str) {
        int x = number / 10;
        str += number % 10;
        if (number < 10) return Integer.parseInt(str);
        return reverse(x, str);
    }

    public static List<Integer> cutTheSticks1(List<Integer> arr) {
        List<Integer> modifiableList = new ArrayList<>(arr);
        List<Integer> resultList = new ArrayList<Integer>();
        resultList.add(arr.size());
        while (modifiableList.size() > 0) {
            Integer min = modifiableList.stream().reduce(modifiableList.get(0), Integer::min);
            modifiableList.removeIf(a -> a == min);
            modifiableList.replaceAll(b -> b - min);
            if (modifiableList.size() != 0)
                resultList.add(modifiableList.size());
        }
        return resultList;
    }

    public static List<Integer> cutTheSticks2(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        res.add(arr.size());
        while (arr.size() > 0) {
            int min = Collections.min(arr);
            arr = arr.stream()
                    .filter(e -> e > min)
                    .map(e -> (e - min))
                    .collect(Collectors.toList());
            System.out.println(arr);
            if (arr.size() > 0) {
                res.add(arr.size());
            }
        }
        return res;
    }

    static boolean kaprekar(int n) {
        if (n == 1)
            return true;
        int sq_n = n * n;
//        int count_digits = 0;
//        while (sq_n != 0) {
//            count_digits++;
//            sq_n /= 10;
//        }
        int numDigits = (int) Math.log10(sq_n) + 1;
        sq_n = n * n;
        for (int r_digits = 1; r_digits < numDigits; r_digits++) {
            int eq_parts = (int) Math.pow(10, r_digits);
            if (eq_parts == n)
                continue;
            int sum = sq_n / eq_parts + sq_n % eq_parts;
            if (sum == n)
                return true;
        }
        return false;
    }

    public static void printModifiedKaprekarNumbers(int p, int q) {
        List<Integer> kaprekarNumbers = new ArrayList<>();
        for (int i = p; i <= q; i++) {
            if (isModifiedKaprekar(i)) {
                kaprekarNumbers.add(i);
            }
        }
        if (kaprekarNumbers.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            for (int kaprekarNumber : kaprekarNumbers) {
                System.out.print(kaprekarNumber + " ");
            }
        }
    }

    public static void printModifiedKaprekarNumberss(int p, int q) {
        List<Integer> kaprekarNumbers = IntStream.rangeClosed(p, q)
                .filter(n -> isModifiedKaprekar(n))
                .boxed()
                .collect(Collectors.toList());
        if (kaprekarNumbers.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            System.out.println(kaprekarNumbers.stream()
                    .map(Object::toString) // Integer overrides toString method]
                    //.map(Integer::toString) ---> Reference to 'toString' is ambiguous, both 'toString(int)' and 'toString()' match
                    //map(a -> a.toString()) // a.toString() -> Integer.toString(a)) [a = Integer]
                    .collect(Collectors.joining(" "))); //<CharSequence, ?, String>
        }
        Stream<Integer> stream = Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<Integer> asList = stream.collect(Collectors.toList()); // Collector<T, ?, List<T>>

    }

    private static boolean isModifiedKaprekar(int n) {
        if (n == 1) {
            return true;
        }
        long sq_n = (long) n * n;
        int numDigits = (int) Math.log10(sq_n) + 1;
        for (int numDigitsLeft = 1; numDigitsLeft < numDigits; numDigitsLeft++) {
            long right = sq_n % (long) Math.pow(10, numDigitsLeft);
            long left = sq_n / (long) Math.pow(10, numDigitsLeft);
            if (right > 0 && left + right == n) {
                return true;
            }
        }
        return false;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;
        int maxA = Collections.max(a);
        int minB = Collections.min(b);
        for (int i = maxA; i <= minB; i++) {
            boolean isFactor = true;
            for (Integer integer : a) {
                if (i % integer != 0) {
                    isFactor = false;
                    break;
                }
            }
            if (isFactor) {
                for (Integer integer : b) {
                    if (integer % i != 0) {
                        isFactor = false;
                        break;
                    }
                }
            }
            if (isFactor) {
                count++;
            }
        }
        return count;
//        // Other solution
//        final int start = a.get(a.size() - 1);
//        final int end = b.get(0);
//        int retval = 0;
//        for (int x = start; x <= end; x += start) {
//            final int val = x;
//            final boolean first = a.stream().allMatch(e -> 0 == val % e);
//            final boolean second = b.stream().allMatch(e -> 0 == e % val);
//            if (first && second) retval++;
//        }
//        return retval;
    }

    public static int howManyGames(int p, int d, int m, int s) {
        int[] counter = new int[1];
        IntStream.iterate(p, e -> e - d).limit(10000).map(x -> x <= m ? m : x).reduce(0, (sub, total) -> {
            int sum = sub + total;
            if (s >= sum) {
                counter[0]++;
            }
            return sum;
        });
        return counter[0];
    }

    public static int howManyGames2(int p, int d, int m, int s) {
        int count = 0;
        int sum = p;
        while (sum <= s) {
            p -= d;
            sum += Math.max(p, m);
            count++;
        }
        return count;
    }

    public static List<Integer> acmTeam(List<String> topic) {
        Map<Integer, Integer> teamTopicsCount = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        // this 'name' variable is to keep the keys in the map separated.
        int name = 0;
        //create the pairings with double for loop
        for (int i = 0; i < topic.size() - 1; i++) {
            char[] person1 = topic.get(i).toCharArray();

            for (int j = i + 1; j < topic.size(); j++) {
                char[] person2 = topic.get(j).toCharArray();
                int topicsKnown = 0;
                for (int k = 0; k < person1.length; k++) {
                    if (person1[k] == '1' || person2[k] == '1') {
                        topicsKnown++;
                    }
                }
                name++;
                teamTopicsCount.put(name, topicsKnown);
            }
        }
        int maxValueInMap = (Collections.max(teamTopicsCount.values()));
        int counter = 0;
        for (Integer key : teamTopicsCount.keySet()) {
            if (teamTopicsCount.get(key).equals(maxValueInMap)) {
                counter++;
            }
        }
        result.add(maxValueInMap);
        result.add(counter);
        return result;
    }

    // Bad Performance
    public static int beautifulTriplets(int d, List<Integer> arr) {
        int count = 0;
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size() - 1; j++) {
                for (int k = i + 2; k < arr.size(); k++) {
                    if (i < j && j < k) {
                        if (arr.get(k) - arr.get(j) == arr.get(j) - arr.get(i) && arr.get(k) - arr.get(j) == d) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int beautifulTripletss(int d, List<Integer> arr) {
        int a = 0;
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            a = arr.get(i);
            if (arr.contains(a + d) && arr.contains(a + 2 * d)) {
                count++;
            }
        }
        return count;
    }

    public static int minimumDistances(List<Integer> a) {
        int dist = 10000;
        int min = a.size();
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).equals(a.get(j))) {
                    dist = j - i;
                    break;
                }
            }
            min = Math.min(min, dist);
        }
        return min < a.size() ? min : -1;
    }

    public static int minimumDistancess(List<Integer> a) {
        AtomicInteger dist = new AtomicInteger(10000);
        AtomicInteger min = new AtomicInteger(a.size());

        IntStream.range(0, a.size() - 1)
                .forEach(i -> IntStream.range(i + 1, a.size())
                        .filter(j -> a.get(i).equals(a.get(j)))
                        .findFirst()
                        .ifPresent(j -> {
                            int distance = j - i;
                            dist.set(Math.min(dist.get(), distance));
                        }));

        return min.get() < a.size() ? min.get() : -1;
    }

    public static int chocolateFeast(int n, int c, int m) {
        int bonus = 0;
        int total = (n / c);
        int newTotal = total;
        while (newTotal / m != 0) {
            bonus += (newTotal / m);
            newTotal = (newTotal / m) + newTotal % m;
        }
        return total + bonus;
    }

    public static int chocolateFeastI(int n, int c, int m) {
        int total = n / c;
        int[] exchangedChocolates = new int[1];
        IntStream.iterate(total, x -> x >= m, x -> {
            exchangedChocolates[0] += x / m;
            return (x / m) + (x % m);
        });   // x -> Integer.compare(x, m) < 0 ? false : true
        return total + exchangedChocolates[0];
    }

    public static List<Integer> serviceLane(List<Integer> width, List<List<Integer>> cases) {
        // Write your code here
        return cases.stream().map(s -> IntStream.range(s.get(0), s.get(1) + 1).mapToObj(k -> width.get(k)).min(Integer::compare).get()).collect(Collectors.toList());
    }

    public static int workbook(int n, int k, List<Integer> arr) {
        // Write your code here
        int pageNumber = 0;
        int special = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (k != 1) {
                pageNumber++;
                for (int j = 1; j <= arr.get(i); j++) {
                    if (j > k && j % k == 1) pageNumber++;
                    if (pageNumber == j) special++;
                }
            } else {
                special += arr.get(i);
            }
        }
        return special;
    }

    public static int workbookss(int n, int k, List<Integer> arr) {
        int[] pageNumber = new int[1];
        int[] special = new int[1];
        IntStream.range(0, arr.size())
                .forEach(i -> IntStream.range(1, arr.get(i) + 1).allMatch(j -> {
                    if (k != 1) pageNumber[0]++;
                    if (j > k && j % k == 1) pageNumber[0]++;
                    if (pageNumber[0] == j) special[0]++;
                    return true;
                }));
        return k == 1 ? arr.stream().mapToInt(x -> x).sum() : special[0];
    }

    public static String fairRations(List<Integer> B) {
        // Write your code here
        if (B.size() == 2) return "NO";
        int count = 0;
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) % 2 != 0) {
                count += 2;
                if (i != B.size() - 1) B.set(i + 1, B.get(i + 1) + 1);
            }
        }
        if (B.get(B.size() - 1) % 2 != 0) return "NO";
        return String.valueOf(count);
    }

    public static String fairRationss(List<Integer> B) {
        int total = 0;
        int previous = -1;
        boolean even = true;
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) % 2 == 1) {
                if (even) {
                    previous = i;
                    even = false;
                } else {
                    total += (i - previous) * 2;
                    even = true;
                }
            }
        }

        if (even) {
            return String.valueOf(total);
        }
        return "NO";
    }

    public static String fairRationsss(List<Integer> B) {
        if (B.size() == 2) return "NO";
        int[] count = {0};
        B.replaceAll(num -> {
            if (num % 2 != 0) {
                count[0] += 2;
                return num + 1;
            }
            return num;
        });
        if (B.get(B.size() - 1) % 2 != 0) return "NO";
        return String.valueOf(count[0]);
    }

    public static int gemstoness(List<String> arr) {
        HashSet<Character> set = new HashSet<>();
        for (Character c : arr.get(0).toCharArray()) {
            set.add(c);
        }
        List<Character> list = new ArrayList<Character>(set);

        for (String v : arr) {
            list.removeIf(c -> !v.contains("" + c));
        }

        return list.size();
    }

    public static int gemstones(List<String> arr) {
        Set<Character> commonMinerals = arr.stream()
                .map(s -> s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()))
                .reduce((set1, set2) -> {
                    set1.retainAll(set2); // Intersection of sets
                    return set1;
                })
                .orElse(new HashSet<>());

        return commonMinerals.size();
    }

    public static int alternatingCharacters(String s) {
        return (int) IntStream.range(0, s.length() - 1).filter(i -> s.charAt(i) == s.charAt(i + 1)).count();
    }

    public static String gameOfThrones(String s) {
        int count = 0;
        boolean odd = false;
        char[] str = Arrays.stream(s.split("")).sorted().collect(Collectors.joining()).toCharArray();
        int[] frequency = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < str.length; j++) {
                if (str[i] == str[j]) count++;
                else break;
            }
            frequency[i] = count;
            i += count - 1;
            count = 0;
        }
        for (int k = 0; k < frequency.length; k++) {
            if (frequency[k] % 2 != 0) {
                if (odd) return "NO";
                odd = true;
            }
        }
        return "YES";
    }

    public static String gameOfThroness(String s) {
        int[] charCount = new int[256]; // Assuming ASCII characters, adjust the size accordingly for Unicode.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount[c]++;
        }
        int counter = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                counter++;
                if (counter > 1) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static String gameOfThronesss(String s) {
        int count = 0;
        int x[] = new int[26];
        for (char c : s.toCharArray())
            count += ++x[c - 'a'] % 2 == 0 ? -1 : 1;
        return count <= 1 ? "YES" : "NO";
    }

    public static List<Integer> stones(int n, int a, int b) {
        Set<Integer> set = new HashSet<>();
        if (n <= 2) {
            for (int i = 0; i <= n; i++) {
                set.add(a * i + b * (n - i));
            }
        } else {
            for (int i = 0; i < n; i++) {
                set.add(a * i + b * (n - 1 - i));
            }
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public static void plusMinus(List<Integer> arr) {
        int size = arr.size();
        double positive = 0;
        double zeros = 0;
        double negative = 0;
        for(int i = 0; i < size; i++) {
            if(arr.get(i) > 0) positive++;
            if(arr.get(i) == 0) zeros++;
            if(arr.get(i) < 0) negative++;
        }
        System.out.format("%.6f%n%.6f%n%.6f", (positive/size), (negative/size), (zeros/size));
    }

    // It gives reverse order!!!

    //i -> i > 0 ? 1 : i < 0 ? -1 : 0 (Natural order but doesn't work)
    // It gives reverse order!!!
    public static void plusMinuss(List<Integer> arr) {
        arr.stream().collect(Collectors.groupingBy(Integer::signum, Collectors.counting())).values().forEach(s -> System.out.printf("%.6f%n", (double) s / arr.size()));
    }

    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0;
        arr.sort(Comparator.naturalOrder());
        for (int i = 0; i < 5; i++) {
            sum += arr.get(i).longValue();
            //System.out.println(sum);
        }
        System.out.printf("%d %d", sum - arr.get(4).longValue(), sum - arr.get(0).longValue());
    }

    public static void minMaxSum(List<Integer> arr) {
        long[] sortedArray = arr.stream()
                .mapToLong(Integer::intValue)
                .sorted()
                .toArray();
        long minSum = Arrays.stream(sortedArray, 0, 4).sum();
        long maxSum = Arrays.stream(sortedArray, 1, 5).sum();
        System.out.println(minSum + " " + maxSum);
    }

    public static String timeConversion(String s) {
        StringBuilder strBuilder = new StringBuilder(s);
        String firstTwo = s.substring(0,2);
        int newFormat = Integer.parseInt(firstTwo) + 12;
        if(s.contains("PM") && !firstTwo.equals("12")) {
            strBuilder.replace(0, 2, ""+newFormat);
        } else if(s.contains("AM") && firstTwo.equals("12")) {
            strBuilder.replace(0, 2, "00");
        }
        return String.valueOf(strBuilder.delete(8,10));
    }

    public static String convertToMilitaryTime(String time) {
        String[] timeParts = time.split(":");
        final String[] hours = {timeParts[0]};
        String minutes = timeParts[1];
        String secondsAndAmPm = timeParts[2];
        Function<String, String> amPmToMilitary = amPm -> {
            if (amPm.equalsIgnoreCase("AM")) {
                if (hours[0].equals("12")) {
                    hours[0] = "00";
                }
            } else if (amPm.equalsIgnoreCase("PM")) {
                if (!hours[0].equals("12")) {
                    int militaryHours = Integer.parseInt(hours[0]) + 12;
                    hours[0] = String.format("%02d", militaryHours);
                }
            }
            return hours[0] + ":" + minutes + ":" + secondsAndAmPm.substring(0, 2);
        };
        return amPmToMilitary.apply(secondsAndAmPm);
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < queries.size(); i++) {
            for (int j = 0; j < strings.size(); j++) {
                if(queries.get(i).equals(strings.get(j))) {
                    count++;
                }
            }
            list.add(count);
            count = 0;
        }
        return list;
    }

    public static List<Integer> matchingStringss(List<String> strings, List<String> queries) {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.range(0, queries.size()).forEach(i -> {
            long count = IntStream.range(0, strings.size()).filter(j -> queries.get(i).equals(strings.get(j))).count();
            list.add((int) count);
        });
        return list;
    }

    public static int lonelyInteger(List<Integer> a) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer number : a) {
            if(!map.containsKey(number)) map.put(number, 1);
            else map.put(number, map.get(number) + 1);
        }
        for(Integer key : map.keySet()) {
            if(map.get(key) == 1) result = key;
        }
        return result;
    }

    // Write a code which returns the Integer appearing only once in the list
    public static int lonelyIntegers(List<Integer> a) {
        int result = 0;
        for (Integer number : a) {
            result ^= number;
        }
        return result;
    }

    // Not correct!!!
    public static long flippingBits(long n) {
        StringBuilder str = new StringBuilder("00000000000000000000000000000000");
        String remain = "";
        long result = 0;
        while (n > 1) {
            remain += String.valueOf(n%2);
            n = n/2;
        }
        System.out.println(remain);
        StringBuilder finalStr = str.replace(32 - remain.length()+1, 33, remain);
        System.out.println(finalStr);
        for(int i = 0; i < finalStr.length(); i++) {
            if(finalStr.charAt(i) == '0') finalStr.setCharAt(i, '1');
            else finalStr.setCharAt(i, '0');
        }
        for(int j = finalStr.length()-1; j >= 0; j--) {
            result += finalStr.charAt(j) * Math.pow(2, (double) j);
        }
        return result;
    }
    public static long flippingBitss(long n) {
        long mask = (1L << 32) - 1;
        return n ^ mask;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.size();
        int sum = 0;
        int opSize = 0;
        for(int i = 0; i < size; i++) {
            sum += arr.get(i).get(i);
            opSize += arr.get(size-i-1).get(i);
        }
        return Math.abs(sum-opSize);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        int[] charCount = new int[100];
        for(int i = 0; i < arr.size(); i++) {
            charCount[arr.get(i)]++;
        }
        for(int i : charCount) {
            list.add(i);
        }
       return list;
    }

    public static String pangrams(String s) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = alphabet.toLowerCase();
        for (int i = 0; i < alphabet.length(); i++) {
            if (!s.contains(alphabet.subSequence(i, i + 1)) && !(s.contains(lowercase.subSequence(i, i + 1)))) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    /*
    A pangram is a string that contains every letter of the alphabet.
    Given a sentence determine whether it is a pangram in the English alphabet.
    Ignore case. Return either pangram or not pangram as appropriate.
    */
/*    public static String pangramss(String s) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String lowercase = alphabet.toLowerCase();
        return alphabet.chars().anyMatch(c -> s.indexOf((char) c) < 0) ? "not pangram" : "pangram";
        //return alphabet.chars().allMatch(c -> s.contains((char)c)).;
        return alphabet.chars().allMatch(c -> s.contains((char)c)) ? "pangram" : "not pangram";
    }*/

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        boolean b = true;
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i)+B.get(i) < k) b = false;
        }
        return b ? "YES" : "NO";
    }

    // Not exactly correct!!!
    public static int birthday(List<Integer> s, int d, int m) {
        return (int) s.stream().flatMap(i -> s.stream().map(j -> List.of(i, j))).filter(list -> list.size() == m).distinct().filter(l -> l.stream().mapToInt(Integer::intValue).sum() == d).count();
    }

    public static int birthdayss(List<Integer> s, int d, int m) {
        int count = 0;
        int[] array = s.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i <= s.size() - m; i++) {
            if (Arrays.stream(array, i, i + m).sum() == d) count++;
        }
        return count;
    }

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) res += "0";
            else res += "1";
        }
        return res;
    }

    public static int findMedian(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        return arr.get((arr.size()/2));
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int size = matrix.size();
        int sum = 0;
        for (int i = 0; i < size/2; i++) {
            for (int j = 0; j < size/2; j++) {
                sum += Math.max(matrix.get(i).get(j),
                        Math.max(matrix.get(size - i - 1).get(j),
                                Math.max(matrix.get(i).get(size - j - 1), matrix.get(size - i - 1).get(size - j - 1))));
            }
        }
        return sum;
    }

/*    public static int sockMerchant(int n, List<Integer> ar) {
        int count = 0;
        ar.sort(Comparator.naturalOrder());
        for (int i = 1; i < ar.size(); i++) {
            int result = ar.get(i-1);
            result ^= ar.get(i);
            if(result != 0) count++;
        }
        return (n-count)/2;
    }*/

    public static int sockMerchant(int n, List<Integer> ar) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer number : ar) {
            if(!map.containsKey(number)) map.put(number, 1);
            else map.put(number, map.get(number) + 1);
        }
        for(Integer value : map.values()) {
            if(value % 2 != 0) count++;
        }
        return (n-count)/2;
    }

    // It's better!
    public static int sockMerchants(int n, List<Integer> ar) {
        Collections.sort(ar);
        int pairs=0;
        for(int i=0;i<ar.size()-1;i++){
            if(ar.get(i).equals(ar.get(i+1))){
                pairs++;
                i++;
            }
        }
        return pairs;
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n+1)/2-1;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static int pageCounts(int n, int p) {
        double start = (double) p/2;
        double end = (double) (n-p)/2;
        double result = end;
        if(start < end) result = start;
        return result == 0.5 ? p % 2 == 0 ? 0 : 1 : (int) result ;
    }

    public static int pageCount(int n, int p) {
        return n/2>=p ? p/2 : n/2 - p/2;
    }

    public static int towerBreakers(int n, int m) {
        if(m == 1) return 2;
        if(n % 2 != 0) return 1;
        else return 2;
    }

public static int towerBreakersss(int n, int m) {
        return m == 1 || n % 2 == 0 ? 2 : 1;
    }

    //String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static String caesarCipher(String s, int k) {
        // Add upperCase check!!!
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String cipher = "";
        for (int i = 0; i < s.length(); i++) {
            int index = alphabet.indexOf(s.charAt(i));
            if (index == -1) cipher += s.charAt(i);
            else if (index + k > 25) cipher += alphabet.charAt(index + k - 26);
            else cipher += alphabet.charAt(index + k);
        }
        return cipher;
    }

    public static String caesarCipherss(String s, int k) {
        for (Character c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c + k > 'z') {
                    int codePoint = (c + k) - 26;
                    s = s.replace(c, (char) (Character.isUpperCase(c) ? Character.toUpperCase(codePoint) : codePoint));
                } else {
                    s = s.replace(c, (char) (Character.isUpperCase(c) ? Character.toUpperCase(c + k) : c + k));
                }
            }
        }
        return s;
    }

    public static String caesarCiphers(String s, int k) {
        String cipher = "";
        for (Character c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                char baseA = Character.isUpperCase(c) ? 'A' : 'a';
                cipher += (char) ((c + k - baseA) % 26 + baseA);
            } else {
                cipher += c;
            }
        }
        return cipher;
    }

    public static int maxMin(int k, List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        int abs = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size()-k; i++) {
            int max = arr.get(i+k-1);
            int min = arr.get(i);
            abs = Math.min(abs, max - min);
        }
        return abs;
    }

/*    public static int solution(int[] A) {
        int result = 0;
        Arrays.sort(A);
        int i = 0;
        for(i = 0; i < A.length-1; i++) {
            if (A[i] > 0) {
                if (A[i] == A[i + 1]) continue;
                else if(A[i + 1] == A[i] + 1) result = A[i] + 1;
                else break;
            }
        }
        if(A[i] > 0 && A[A.length-1] > A[i]) result = A[A.length-1]+1;
        else if (A[i] > 0) result = A[i]+1;
        else result = 1;
        return result;
    }*/

    public static int solution(int[] A) {
        // Write a java method for given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
        Arrays.sort(A);
        int result = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == result) result++;
        }
        return result;
    }

    public static int solutions(String E, String L) throws ParseException {
/*        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:MM");
        Date entry = new Date("10:00");
        format.parse(E);  */
        int parkingTime = 0;
        String[] entry = E.split(":");
        String[] left = L.split(":");
        int hour = Integer.parseInt(left[0]) - Integer.parseInt(entry[0]);
        int minute = Integer.parseInt(left[1]) - Integer.parseInt(entry[1]);
        if (hour < 1) return 5;
        if(hour >= 1 && minute > 0) parkingTime = hour;
        else if (hour >= 1) parkingTime = hour-1;
        return 5 + parkingTime*4;
    }

    static int findParent(int height,
                          int node) {
        int start = 1;
        int end = (int) Math.pow(2, height) - 1;

        // Condition to check whether
        // the given node is a root node.
        // if it is then return -1 because
        // root node has no parent
        if (end == node)
            return -1;

        // Loop till we found
        // the given node
        while (node >= 1) {
            end = end - 1;

            // Finding the middle node of the
            // tree because at every level
            // tree parent is
            // divided into two halves
            int mid = start + (end - start) / 2;

            // if the node is found return
            // the parent always the child
            // nodes of every node
            // is node*/2 or (node-1)
            if (mid == node || end == node) {
                return (end + 1);
            }

            // if the node to be found
            // is greater than the mid
            // search for left subtree else
            // search in right subtree
            else if (node < mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    private static List<Long> maxSubSet(List<Integer> lst) {
        List<Long> result = new ArrayList<>();
        for (Integer i : lst) {
            long sum = 0;
            for (int j = 1; j <= i/2; j++) {
                if (i % j == 0) sum += j;
            }
            result.add(sum+i);
        }
        return result;
    }

    // Convert a number base of 10 to base 2
    public static long flippingBitsWithNegation(int decimal) {
        String binaryString = Integer.toBinaryString(decimal);

/*      String binary = "";
        while (decimal > 0) {
            binary = decimal % 2 + binary;
            decimal /= 2;
        }*/

        // Flip bits of binary string by negating '0' at the beginning until the first '1'
        //binary = binary.replaceFirst("^0*", "");

/*      int index = 0;
        int firstOne = 0;
        while(binaryString.charAt(index) != '1') {
            firstOne = index;
        }
        String substring = binaryString.substring(firstOne);*/

        //String substring =  StringUtils.leftPad(binaryString, 10, "0");
        String substring = binaryString.replaceFirst("^0*", "");
        int intRepresentation = Integer.parseUnsignedInt(substring, 2);
        int mask = (1 << substring.length()) - 1 ;
        return intRepresentation ^ mask;
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int middlePosition = (low + high) / 2;
            int middleNumber = arr[middlePosition];
            if(key == middleNumber) return middlePosition;
            if(key > middleNumber) low = middlePosition + 1;
            else high = middlePosition - 1;
        }
        return -1;
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> seqList = new ArrayList<>();
        int lastAnswer = 0;

        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int index = (x ^ lastAnswer) % n;

            if (queryType == 1) {
                seqList.get(index).add(y);
            } else if (queryType == 2) {
                lastAnswer = seqList.get(index).get(y % seqList.get(index).size());
                result.add(lastAnswer);
            }
        }
        return result;
    }

    public static String gridChallengeI(List<String> grid) {
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            char[] ch = grid.get(i).toCharArray();
            Arrays.sort(ch);
            list.add(ch);
        }
        for (int k = 0; k < list.get(0).length; k++) {
            char c1 = 'a';
            for (int j = 0; j < list.size(); j++) {
                char[] chars = list.get(j);
                char c = chars[k];
                if (c1 <= c) {
                    c1 = c;
                } else return "NO";
            }
        }
        return "YES";
    }

    public static String gridChallenge(List<String> grid) {
        String result = "YES";
        for (int i = 0; i < grid.size(); i++) {
            char[] chars = grid.get(i).toCharArray();
            Arrays.sort(chars);
            grid.set(i, new String(chars));
        }
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length()-1; j++) {
                if (grid.get(j).charAt(i) > grid.get(j+1).charAt(i)) {
                    result = "NO";
                    break;
                }
            }
        }
        return result;
    }

    public static String balancedSums(List<Integer> arr) {
        if(arr.size() == 1) return "YES";
        if(arr.size() == 2) return "NO";
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum = sum + arr.get(i);
        }
        int currentSum = 0;
        for (int j = 0; j < arr.size(); j++) {
            currentSum+= arr.get(j);
            int leftSum = currentSum - arr.get(j);
            int rightSum = sum - currentSum;
            if(leftSum == rightSum) return "YES";
        }
        return "NO";
    }

    public static int superDigit(String n, int k) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < n.length(); i++) {
            result = result.add(BigInteger.valueOf(Character.getNumericValue(n.charAt(i))));
        }
        result = result.multiply(BigInteger.valueOf(k));
        if(result.compareTo(BigInteger.valueOf(10)) < 0) return result.intValue();
        return superDigit(result.toString(), 1);
    }

    public static int superDigits(String n, int k) {
        StringBuilder nk = new StringBuilder();
        for (int i = 0; i < k; i++) {
            nk.append(n);
        }
        long superDigit = calculateSuperDigit(nk.toString());
        return (int) superDigit;
    }

    private static long calculateSuperDigit(String str) {
        if(str.length() == 1) {
            return Long.parseLong(str);
        }
        long sum = 0;
        for (char ch : str.toCharArray()) {
            sum += Character.getNumericValue(ch);
        }
        return calculateSuperDigit(String.valueOf(sum));
    }

    public static String counterGame(long n) {
        int turn = 0;
        while (n > 1) {
            if ((n & (n - 1)) == 0) {
                n = n >> 1;
            } else {
                int p = 0;
                long v = n;
                while ((v = v >> 1) > 0)
                    p++;
                n = n - (1l << p);
            }
            turn++;
        }
        return turn % 2 == 0 ? "Richard" : "Louise";
    }

    public static long sumXor(long n) {
        int counter = 0;
        while (n > 0) {
            if ((n & 1) == 0) // count only when n|x == n^x
                counter++;
            n = n >> 1; //drop right-most digit
            //(cut the number in half)
        }
        return 1l << counter; //a nice way to rise a number to power of 2
    }

    public static void fizzBuzz(int n) {
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0) System.out.print("Fizz");
            if(i % 5 == 0) System.out.print("Buzz");
            if(i % 3 != 0 || i % 5 != 0) System.out.print(i);
        }
        System.out.println();
    }

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                return -1;
            }
            left++;
            right--;
        }
        return -1;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

// Determine minimum number of characters to change to make the two substrings into anagram of one another
    public static int anagram(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < letters.length; i++) {
            if(letters[i] % 2 != 0) result++;
        }
        return result;
    }

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n < 2) return grid;
        String fullRow = "O".repeat(grid.get(0).length());
        List<String> fullGrid = IntStream.range(0, grid.size())
                .mapToObj(i -> fullRow)
                .collect(Collectors.toList());
        grid = doBoom(fullGrid, grid);
        List<String> grid2 = doBoom(fullGrid, grid);
        return n % 2 == 0 ? fullGrid : n % 4 == 1 ? grid2 : grid;
    }

    private static List<String> doBoom(List<String> fullGrid, List<String> grid) {
        int length = grid.get(0).length();
        int height = grid.size();
        List<StringBuilder> builders = fullGrid.stream().
                map(StringBuilder::new).
                collect(Collectors.toList());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    builders.get(i).setCharAt(j, '.');
                    if (j != 0) builders.get(i).setCharAt(j - 1, '.');
                    if (j < length - 1) builders.get(i).setCharAt(j + 1, '.');
                    if (i != 0) builders.get(i - 1).setCharAt(j, '.');
                    if (i < height - 1) builders.get(i + 1).setCharAt(j, '.');
                }
            }
        }
        return builders.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

    public static List<String> bomberMan2(int n, List<String> grid) {
        // Convert grid to char array for easier manipulation
        char[][] matrix = new char[grid.size()][grid.get(0).length()];
        for (int i = 0; i < grid.size(); i++) {
            matrix[i] = grid.get(i).toCharArray();
        }

        if (n == 1) {
            return grid; // No change after 1 second
        } else if (n % 2 == 0) {
            // After even seconds, all cells are filled with bombs
            fillGrid(matrix, 'O');
        } else {
            // After odd seconds, bombs detonate every 3rd second
            detonateBombs(matrix);
            fillGrid(matrix, 'O');
            if ((n / 2) % 2 == 1) {
                detonateBombs(matrix);
            }
        }

        // Convert char array back to list of strings
        List<String> result = new ArrayList<>();
        for (char[] row : matrix) {
            result.add(String.valueOf(row));
        }
        return result;
    }

    private static void fillGrid(char[][] grid, char bombChar) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 'X') {
                    grid[i][j] = bombChar;
                }
            }
        }
    }

    private static void detonateBombs(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] detonated = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'O') {
                    detonated[i][j] = true;
                    if (i > 0) detonated[i - 1][j] = true; // Up
                    if (i < rows - 1) detonated[i + 1][j] = true; // Down
                    if (j > 0) detonated[i][j - 1] = true; // Left
                    if (j < cols - 1) detonated[i][j + 1] = true; // Right
                }
            }
        }

        // Update grid based on detonated bombs
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (detonated[i][j]) {
                    grid[i][j] = '.';
                }
            }
        }
    }

    public static void minimumBribess(List<Integer> q) {
        int swaps=0;
        for (int index = q.size()-1; index >= 0; index--) {
            int rightValue = index+1;
            if (q.get(index) != rightValue) {
                if ((index-1) >= 0 && q.get(index-1) == rightValue) {
                    q.set(index-1, q.get(index));
                    q.set(index, rightValue);
                    swaps += 1;
                } else if ((index-2) >= 0 && q.get(index-2) == rightValue) {
                    q.set(index-2, q.get(index-1));
                    q.set(index-1, q.get(index));
                    q.set(index, rightValue);
                    swaps += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
        int bribes = 0;
        for(int i = q.size()-2;i>=0;i--){
            int diff = q.get(i) - (i +1);

            if(diff > 2){
                System.out.println("Too chaotic");
                return;
            }

            while(diff-- > 0){
                bribes++;
                int temp = q.get(i+1);
                q.set(i+1,q.get(i));
                q.set(i,temp);
                if(diff == 1) i++;
            }
        }
        System.out.println(bribes);
    }

    public static String isValid(String s) {
        char[] arr = new char[123];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int number = arr[s.charAt(0)];
        int count = 0;
        for (char ch : arr) {
            if (ch > number ||ch != 0 && ch < number) count++;
            if (count > 1) {
                return "NO";
            }
        }
        return "YES";
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = ranked.stream().distinct().collect(Collectors.toList());
        int rank = 0;
        for (int i = player.size() - 1; i >= 0; i--) {
            for (int j = rank; j < ranks.size(); j++) {
                if (player.get(i) >= ranks.get(j)) {
                    player.set(i, rank + 1);
                    break;
                }
                rank++;
            }
            if (rank == ranks.size()) player.set(i, rank + 1);
        }
        return player;
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode node = llist;
        SinglyLinkedListNode prev = null;
        while(node != null){
            SinglyLinkedListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode curr = llist;
        DoublyLinkedListNode next = null;
        DoublyLinkedListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 1 <--> 2 <--> 3 <--> 4 <--> 5
    // 5 <--> 4 <--> 3 <--> 2 <--> 1
    public static DoublyLinkedListNode reverses(DoublyLinkedListNode llist) {
        DoublyLinkedListNode currNode = llist;
        DoublyLinkedListNode newHead = llist;
        while (currNode != null) {
            DoublyLinkedListNode temp = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = temp;
            newHead = currNode;
            currNode = currNode.prev;
        }
        return newHead;
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        int count = 0;
        if (root == null) return;
        inOrder(root.left);
        count++;
        if (count == 1) System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        int count = 0;
        postOrder(root.left);
        count++;
        postOrder(root.right);
        count++;
        if (count == 2) System.out.print(root.data + " ");
    }

    public static int height(Node root) {
        if (root == null) return -1;
        return 1 + height(root.left) + height(root.right);
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
    }

    public static Node insert(Node root, int data) { // 4 -> 7 -> null
        if (root == null) {
            return new Node(data); // 6
        } else {
            Node curr;
            if (data < root.data) {
                curr = insert(root.left, data); // null
                root.left = curr;
            } else {
                curr = insert(root.right, data); // 7
                root.right = curr;
            }
            return root;
        }
    }

    public static Node lca(Node root, int v1, int v2) { // 4
        if(root.data == v1 || root.data == v2) return root;
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }
        return root;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode merged = new SinglyLinkedListNode(0);
        SinglyLinkedListNode h1 = head1;
        SinglyLinkedListNode h2 = head2;
        SinglyLinkedListNode m = merged;

        while(h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                m.next = h1;
                h1 = h1.next;
            } else {
                m.next = h2;
                h2 = h2.next;
            }
            m = m.next;
        }

        if (h1 != null) m.next = h1;
        if (h2 != null) m.next = h2;

        return merged.next;
    }

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j <= arr.size() - 1; j++) {
                if (arr.get(i) + arr.get(j) == m) {
                    list.add(i + 1);
                    list.add(j + 1);
                }
            }
        }
        return list;
    }

    public static List<Integer> icecreamParlors(int m, List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.subList(i + 1, arr.size()).contains(m - arr.get(i))) {
                result.add(i + 1);
                result.add(arr.subList(i + 1, arr.size()).indexOf(m - arr.get(i)) + 2 + i);
                break;
            }
        }
        return result;
    }

    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='['|| s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()) return "NO";

                if((s.charAt(i)==')' && stack.pop() =='(')
                        || (s.charAt(i)==']' && stack.pop() =='[')
                        || s.charAt(i)=='}' && stack.pop() =='{') continue;
                else return "NO";
            }
        }
        return stack.isEmpty()? "YES":"NO";
    }

    public static String isBalancedList(List<String> s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (String str : s) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) return "NO";

                    if ((ch == ')' && stack.pop() == '(')
                            || (ch == ']' && stack.pop() == '[')
                            || (ch == '}' && stack.pop() == '{')) continue;
                    else return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    private static List<Integer> getPrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        int ith = 2;
        // we only need q primes
        while (primes.size() < q) {
            if (new BigInteger(String.valueOf(ith)).isProbablePrime(100)) {
                primes.add(ith);
            }
            ith++;
        }
        return primes;
    }

    public static List<Integer> getPrimess(int q) {
        List<Integer> primes = new ArrayList<Integer>();
        boolean isPrime;
        if (q < 2) {
            primes.add(2);
        } else {
            for (int i = 2; primes.size() < q; i++) {
                isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) primes.add(i);
            }
        }
        return primes;
    }

    /*
        This method creates a list of primes with the size of q (It's lik getPrimes method)
    */
    public static List<Integer> sieve(int q) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        int i = 3;
        int count = 1;

        while (count <= q) {
            boolean isPrime = true;

            for (int p : primes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
                count++;
            }

            i += 2;
        }

        return primes;
    }

    public static List<Integer> waiter(List<Integer> numbers, int q) {
        List<Integer> primes = sieve(q);
        List<Integer> answers = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.addAll(numbers);

        for (int i = 0; i < q; i++) {
            Stack<Integer> temp1 = new Stack<>();
            Stack<Integer> temp2 = new Stack<>();

            while (!stack.isEmpty()) {
                int item = stack.pop();

                if (item % primes.get(i) == 0) {
                    temp2.push(item);
                } else {
                    temp1.push(item);
                }
            }

            stack = temp1;

            while (!temp2.isEmpty()) {
                answers.add(temp2.pop());
            }
        }

        while (!stack.isEmpty()) {
            answers.add(stack.pop());
        }

        return answers;
    }

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int curr = 0;
        int res = 1;
        for(int i = 0; i < petrolpumps.size(); i++) {
            curr += petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1);
            if(curr < 0) {
                curr = 0;
                res = i+1;
            }
        }
        return res;
    }

    public static int pairs(int k, List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int pair = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            int numPlusK = num + k;
            if (map.containsKey(numPlusK)) {
                pair++;
            }
        }
        return pair;
    }

    public static List<String> bigSorting(List<String> unsorted) {
        Comparator<String> comp=Comparator
                .comparingInt(String::length)
                .thenComparing(String::compareTo);
        Collections.sort(unsorted,comp);
        return unsorted;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int height1 = 0, height2 = 0, height3 = 0;
        for (Integer i1 : h1) height1 += i1;
        for (Integer i2 : h2) height2 += i2;
        for (Integer i3 : h3) height3 += i3;
        while (height1 != height2 || height2 != height3) {
            if (height1 >= height2 && height1 >= height3) {
                height1 -= h1.remove(0);
            } else if (height2 >= height1 && height2 >= height3) {
                height2 -= h2.remove(0);
            } else if (height3 >= height1 & height3 >= height2) {
                height3 -= h3.remove(0);
            }
        }
        return height1;
    }

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubArr = Integer.MIN_VALUE;
        int maxSubSeq = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            currentSum += num;
            if(currentSum > maxSubArr) {
                maxSubArr = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
            if(num >= 0) maxSubSeq += num;
            if (num > maxSubSeq) maxSubSeq = num;
        }
        return new ArrayList<>(Arrays.asList(maxSubArr, maxSubSeq));
    }

//    public static int legoBlocks(int n, int m) {
//        int md = 100000007;
//        int size = 1;
//        for (int i = 0; i < n; i++) {
//            size*=m;
//        }
//        return (size - permutation(m-1))%md;
//    }
//
//    public static int permutation(int number) {
//        if (number == 1) return 1;
//        return number * permutation(number-1);
//    }

    public static int cookies(int k, List<Integer> A) {
        int operations = 0;
        PriorityQueue<Integer> cookies = new PriorityQueue<>(A);   // Same logic with the MinHeap class

        while(cookies.size() > 1 && cookies.peek() < k) {
            int combined = cookies.poll() + 2 * cookies.poll();
            cookies.offer(combined);
            operations++;
        }

        return cookies.peek() < k ? -1 : operations;
    }

    public static int hackerlandRadioTransmitter(List<Integer> houses, int distance) {
        int howMuchAntena = houses.isEmpty() ? 0 : 1;
        Collections.sort(houses);
        int where = houses.get(0);
        int first=houses.get(0);
        for (Integer house : houses) {
            if (first + distance >= house) {
                where = house;
            } else if (distance + where < house) {
                first = house;
                howMuchAntena++;
            }
        }
        return howMuchAntena;
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        NavigableSet<Integer> houses = new TreeSet<>(x);
        int transmitters = 0;
        Integer houseNum = houses.first();
        do {
            houseNum = houses.floor(houseNum + k);
            transmitters++;
            houseNum = houses.higher(houseNum + k);
        } while(houseNum!= null && houseNum<=houses.last());
        return transmitters;
    }

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) { // {2,3,4,5,6}
        int n = arr.size();
        List<Integer> results = new ArrayList<>();
        for (int d : queries) {
            Deque<Integer> dq = new LinkedList<>();
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                while (!dq.isEmpty() && arr.get(dq.peekLast()) < arr.get(i)) {
                    dq.pollLast();
                }
                dq.addLast(i);
                while (!dq.isEmpty() && dq.peekFirst() <= i - d) {
                    dq.pollFirst();
                }
                if (i >= d - 1) {
                    assert !dq.isEmpty();
                    best = Math.min(best, arr.get(dq.peekFirst()));
                }
            }
            results.add(best);
        }
        return results;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] array = new long[n + 1];
        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            array[a - 1] += k;
            if (b < n) {
                array[b] -= k;
            }
        }
        long maxVal = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += array[i];
            if (currentSum > maxVal) {
                maxVal = currentSum;
            }
        }
        return maxVal;
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        char[] ans = s.toCharArray();
        boolean[] mark = new boolean[n];
        int l = 0, r = n - 1;
        while (l <= r) {
            if (ans[l] != ans[r]) {
                if (ans[l] > ans[r]) {
                    ans[r] = ans[l];
                } else {
                    ans[l] = ans[r];
                }
                mark[l] = mark[r] = true;
                k--;
            }
            l++;
            r--;
        }

        if (k < 0) {
            return "-1";
        }
        l = 0; r = n - 1;
        while (l <= r) {
            if (l == r) {
                if (k > 0 && ans[l] < '9') {
                    ans[l] = '9';
                }
            } else {
                if (ans[l] < '9') {
                    if (mark[l] || mark[r]) {
                        if (k > 0) {
                            ans[l] = ans[r] = '9';
                            k--;
                        }
                    } else {
                        if (k > 1) {
                            ans[l] = ans[r] = '9';
                            k -= 2;
                        }
                    }
                }
            }
            l++;
            r--;
        }
        return new String(ans);
    }

    public static int lilysHomework(List<Integer> arr) {
        int n = arr.size();
        int[] a = new int[n];
        int[] p = new int[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            a[i] = arr.get(i);
            p[i] = i;
        }

        Integer[] pObj = new Integer[n];
        for (int i = 0; i < n; ++i) {
            pObj[i] = i;
        }

        Arrays.sort(pObj, Comparator.comparingInt(i -> a[i])); // 3,0,2,1 ---- 3,7,12,15
        for (int i = 0; i < n; ++i) {
            p[i] = pObj[i];
        }

        int res = solve(n, p, used);
        reverse(p, 0, n);
        res = Math.min(res, solve(n, p, used));
        return res;
    }

    private static int solve(int n, int[] p, boolean[] used) {
        Arrays.fill(used, false);
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            int x = i;
            if (used[x])
                continue;
            while (!used[x]) {
                used[x] = true;
                x = p[x];
            }
            cur++;
        }
        return n - cur;
    }

    private static void reverse(int[] array, int from, int to) {
        int i = from, j = to - 1;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static List<Integer> findLargestRectangles(int height, int width, int[] isVertical, int[] distance) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer> verticalCuts = new TreeSet<>();
        TreeSet<Integer> horizontalCuts = new TreeSet<>();

        verticalCuts.add(0);
        verticalCuts.add(width);
        horizontalCuts.add(0);
        horizontalCuts.add(height);

        for (int i = 0; i < isVertical.length; i++) {
            if (isVertical[i] == 1) {
                verticalCuts.add(distance[i]);
            } else {
                horizontalCuts.add(distance[i]);
            }

            // Find the maximum width
            Integer maxWidth = 0;
            Integer prev = null;
            for (Integer cut : verticalCuts) {
                if (prev != null) {
                    maxWidth = Math.max(maxWidth, cut - prev);
                }
                prev = cut;
            }

            // Find the maximum height
            Integer maxHeight = 0;
            prev = null;
            for (Integer cut : horizontalCuts) {
                if (prev != null) {
                    maxHeight = Math.max(maxHeight, cut - prev);
                }
                prev = cut;
            }

            result.add(maxWidth * maxHeight);
        }

        return result;
    }

    public Problems() {
        super();
    }

    public static void kaprekarNumbers(int p, int q) {
        boolean flag = false;
        long square = 0;
        for (int i = p; i <= q; i++) {
            int d = String.valueOf(p).length();
            square = p*p;
            int sq = String.valueOf(q).length();
            String right = String.valueOf(square).substring(sq-d);
            System.out.println(right);
            String left = String.valueOf(square).substring(0, sq-d);
            System.out.println(left);
            if(p == Integer.parseInt(right) + Integer.parseInt(left)) {
                System.out.print(p + " ");
                flag = true;
            }
        }
        if(!flag) System.out.print("INVALID RANGE");
    }

    /*
                                       permutation("ABC", "")
                     /                              |                                    \
         perm("BC", "A")                      perm("AC", "B")                     perm("AB", "C")
         /                \                  /               \                      /            \
    perm("C", "AB")  perm("B", "AC")    perm("C", "BA")    perm("A", "BC")     perm("B", "CA")   perm("A", "CB")
            |            |                      |            |                        |            |
          "ABC"       "ACB"                   "BAC"        "BCA"                    "CAB"        "CBA"
    */
    public static void permutation(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i= 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

}


