main.main STEXT size=837 args=0x0 locals=0x118 funcid=0x0 align=0x0
	0x0000 00000 (main.go:14)	TEXT	main.main(SB), ABIInternal, $280-0
	0x0000 00000 (main.go:14)	LEAQ	-152(SP), R12
	0x0008 00008 (main.go:14)	CMPQ	R12, 16(R14)
	0x000c 00012 (main.go:14)	PCDATA	$0, $-2
	0x000c 00012 (main.go:14)	JLS	826
	0x0012 00018 (main.go:14)	PCDATA	$0, $-1
	0x0012 00018 (main.go:14)	SUBQ	$280, SP
	0x0019 00025 (main.go:14)	MOVQ	BP, 272(SP)
	0x0021 00033 (main.go:14)	LEAQ	272(SP), BP
	0x0029 00041 (main.go:14)	FUNCDATA	$0, gclocals쨌3CgL1OMj4PK20UKKkS8Bfw==(SB)
	0x0029 00041 (main.go:14)	FUNCDATA	$1, gclocals쨌SdD0uXGADlloNMAQcAFuzg==(SB)
	0x0029 00041 (main.go:14)	FUNCDATA	$2, main.main.stkobj(SB)
	0x0029 00041 (<unknown line number>)	NOP
	0x0029 00041 (main.go:15)	MOVQ	os.Stdin(SB), DX
	0x0030 00048 ($GOROOT\src\bufio\scan.go:88)	LEAQ	main..autotmp_33+144(SP), DI
	0x0038 00056 ($GOROOT\src\bufio\scan.go:88)	PCDATA	$0, $-2
	0x0038 00056 ($GOROOT\src\bufio\scan.go:88)	NOP
	0x0040 00064 ($GOROOT\src\bufio\scan.go:88)	DUFFZERO	$322
	0x0053 00083 ($GOROOT\src\bufio\scan.go:89)	PCDATA	$0, $-1
	0x0053 00083 ($GOROOT\src\bufio\scan.go:89)	LEAQ	go.itab.*os.File,io.Reader(SB), SI
	0x005a 00090 ($GOROOT\src\bufio\scan.go:89)	MOVQ	SI, main..autotmp_33+144(SP)
	0x0062 00098 ($GOROOT\src\bufio\scan.go:89)	MOVQ	DX, main..autotmp_33+152(SP)
	0x006a 00106 ($GOROOT\src\bufio\scan.go:90)	LEAQ	bufio.ScanLines쨌f(SB), DX
	0x0071 00113 ($GOROOT\src\bufio\scan.go:90)	MOVQ	DX, main..autotmp_33+160(SP)
	0x0079 00121 ($GOROOT\src\bufio\scan.go:91)	MOVQ	$65536, main..autotmp_33+168(SP)
	0x0085 00133 (<unknown line number>)	NOP
	0x0085 00133 (main.go:16)	MOVQ	os.Stdout(SB), SI
	0x008c 00140 (main.go:16)	MOVQ	SI, main..autotmp_56+72(SP)
	0x0091 00145 ($GOROOT\src\bufio\bufio.go:602)	XCHGL	AX, AX
	0x0092 00146 ($GOROOT\src\bufio\bufio.go:593)	LEAQ	type.uint8(SB), AX
	0x0099 00153 ($GOROOT\src\bufio\bufio.go:593)	MOVL	$4096, BX
	0x009e 00158 ($GOROOT\src\bufio\bufio.go:593)	MOVQ	BX, CX
	0x00a1 00161 ($GOROOT\src\bufio\bufio.go:593)	PCDATA	$1, $1
	0x00a1 00161 ($GOROOT\src\bufio\bufio.go:593)	CALL	runtime.makeslice(SB)
	0x00a6 00166 ($GOROOT\src\bufio\bufio.go:592)	MOVUPS	X15, main..autotmp_35+80(SP)
	0x00ac 00172 ($GOROOT\src\bufio\bufio.go:592)	MOVUPS	X15, main..autotmp_35+96(SP)
	0x00b2 00178 ($GOROOT\src\bufio\bufio.go:592)	MOVUPS	X15, main..autotmp_35+112(SP)
	0x00b8 00184 ($GOROOT\src\bufio\bufio.go:592)	MOVUPS	X15, main..autotmp_35+128(SP)
	0x00c1 00193 ($GOROOT\src\bufio\bufio.go:593)	MOVQ	AX, main..autotmp_35+96(SP)
	0x00c6 00198 ($GOROOT\src\bufio\bufio.go:593)	MOVQ	$4096, main..autotmp_35+104(SP)
	0x00cf 00207 ($GOROOT\src\bufio\bufio.go:593)	MOVQ	$4096, main..autotmp_35+112(SP)
	0x00d8 00216 ($GOROOT\src\bufio\bufio.go:594)	LEAQ	go.itab.*os.File,io.Writer(SB), DX
	0x00df 00223 ($GOROOT\src\bufio\bufio.go:594)	MOVQ	DX, main..autotmp_35+128(SP)
	0x00e7 00231 ($GOROOT\src\bufio\bufio.go:594)	MOVQ	main..autotmp_56+72(SP), DX
	0x00ec 00236 ($GOROOT\src\bufio\bufio.go:594)	MOVQ	DX, main..autotmp_35+136(SP)
	0x00f4 00244 (main.go:18)	XCHGL	AX, AX
	0x00f5 00245 ($GOROOT\src\bufio\scan.go:280)	CMPB	main..autotmp_33+264(SP), $0
	0x00fd 00253 ($GOROOT\src\bufio\scan.go:280)	NOP
	0x0100 00256 ($GOROOT\src\bufio\scan.go:280)	JNE	806
	0x0106 00262 ($GOROOT\src\bufio\scan.go:283)	LEAQ	bufio.ScanLines쨌f(SB), CX
	0x010d 00269 ($GOROOT\src\bufio\scan.go:283)	MOVQ	CX, main..autotmp_33+160(SP)
	0x0115 00277 (main.go:20)	LEAQ	main..autotmp_33+144(SP), AX
	0x011d 00285 (main.go:20)	PCDATA	$1, $2
	0x011d 00285 (main.go:20)	NOP
	0x0120 00288 (main.go:20)	CALL	bufio.(*Scanner).Scan(SB)
	0x0125 00293 (<unknown line number>)	NOP
	0x0125 00293 ($GOROOT\src\bufio\scan.go:113)	MOVQ	main..autotmp_33+176(SP), BX
	0x012d 00301 ($GOROOT\src\bufio\scan.go:113)	MOVQ	main..autotmp_33+184(SP), CX
	0x0135 00309 ($GOROOT\src\bufio\scan.go:113)	XORL	AX, AX
	0x0137 00311 ($GOROOT\src\bufio\scan.go:113)	CALL	runtime.slicebytetostring(SB)
	0x013c 00316 ($GOROOT\src\bufio\scan.go:113)	NOP
	0x0140 00320 (main.go:21)	CALL	strconv.Atoi(SB)
	0x0145 00325 (main.go:21)	MOVQ	AX, main.N+48(SP)
	0x014a 00330 (main.go:22)	MOVQ	AX, BX
	0x014d 00333 (main.go:22)	MOVQ	BX, CX
	0x0150 00336 (main.go:22)	LEAQ	type.int(SB), AX
	0x0157 00343 (main.go:22)	CALL	runtime.makeslice(SB)
	0x015c 00348 (main.go:22)	MOVQ	AX, main..autotmp_57+64(SP)
	0x0161 00353 (main.go:22)	XORL	CX, CX
	0x0163 00355 (main.go:24)	JMP	423
	0x0165 00357 (main.go:24)	MOVQ	CX, main.i+40(SP)
	0x016a 00362 (main.go:25)	LEAQ	main..autotmp_33+144(SP), AX
	0x0172 00370 (main.go:25)	PCDATA	$1, $3
	0x0172 00370 (main.go:25)	CALL	bufio.(*Scanner).Scan(SB)
	0x0177 00375 (<unknown line number>)	NOP
	0x0177 00375 ($GOROOT\src\bufio\scan.go:113)	MOVQ	main..autotmp_33+176(SP), BX
	0x017f 00383 ($GOROOT\src\bufio\scan.go:113)	MOVQ	main..autotmp_33+184(SP), CX
	0x0187 00391 ($GOROOT\src\bufio\scan.go:113)	XORL	AX, AX
	0x0189 00393 ($GOROOT\src\bufio\scan.go:113)	CALL	runtime.slicebytetostring(SB)
	0x018e 00398 (main.go:26)	CALL	strconv.Atoi(SB)
	0x0193 00403 (main.go:27)	MOVQ	main.i+40(SP), CX
	0x0198 00408 (main.go:27)	MOVQ	main..autotmp_57+64(SP), DX
	0x019d 00413 (main.go:27)	MOVQ	AX, (DX)(CX*8)
	0x01a1 00417 (main.go:24)	INCQ	CX
	0x01a4 00420 (main.go:32)	MOVQ	DX, AX
	0x01a7 00423 (main.go:24)	MOVQ	main.N+48(SP), DX
	0x01ac 00428 (main.go:24)	CMPQ	DX, CX
	0x01af 00431 (main.go:24)	JGT	357
	0x01b1 00433 (main.go:24)	XORL	CX, CX
	0x01b3 00435 (main.go:24)	JMP	506
	0x01b5 00437 (main.go:38)	PCDATA	$1, $-1
	0x01b5 00437 (<unknown line number>)	NOP
	0x01b5 00437 (main.go:38)	MOVQ	(AX)(CX*8), CX
	0x01b9 00441 ($GOROOT\src\strconv\itoa.go:35)	MOVL	$10, BX
	0x01be 00446 ($GOROOT\src\strconv\itoa.go:35)	MOVQ	CX, AX
	0x01c1 00449 ($GOROOT\src\strconv\itoa.go:35)	PCDATA	$1, $4
	0x01c1 00449 ($GOROOT\src\strconv\itoa.go:35)	CALL	strconv.FormatInt(SB)
	0x01c6 00454 (main.go:38)	MOVQ	BX, CX
	0x01c9 00457 (main.go:38)	MOVQ	AX, BX
	0x01cc 00460 (main.go:38)	LEAQ	main..autotmp_35+80(SP), AX
	0x01d1 00465 (main.go:38)	CALL	bufio.(*Writer).WriteString(SB)
	0x01d6 00470 (main.go:39)	LEAQ	main..autotmp_35+80(SP), AX
	0x01db 00475 (main.go:39)	MOVL	$10, BX
	0x01e0 00480 (main.go:39)	CALL	bufio.(*Writer).WriteByte(SB)
	0x01e5 00485 (main.go:30)	MOVQ	main..autotmp_57+64(SP), CX
	0x01ea 00490 (main.go:30)	MOVQ	main.N+48(SP), DX
	0x01ef 00495 (main.go:30)	MOVQ	main.j+24(SP), SI
	0x01f4 00500 (main.go:32)	MOVQ	CX, AX
	0x01f7 00503 (main.go:30)	MOVQ	SI, CX
	0x01fa 00506 (main.go:30)	LEAQ	-1(DX), SI
	0x01fe 00510 (main.go:30)	NOP
	0x0200 00512 (main.go:30)	CMPQ	CX, SI
	0x0203 00515 (main.go:30)	JGE	549
	0x0205 00517 (main.go:30)	MOVQ	CX, main.i+32(SP)
	0x020a 00522 (main.go:31)	LEAQ	1(CX), SI
	0x020e 00526 (main.go:31)	MOVQ	SI, main.j+24(SP)
	0x0213 00531 (main.go:31)	MOVQ	SI, BX
	0x0216 00534 (main.go:31)	JMP	625
	0x0218 00536 (main.go:38)	CMPQ	DX, CX
	0x021b 00539 (main.go:38)	JHI	437
	0x021d 00541 (main.go:38)	NOP
	0x0220 00544 (main.go:38)	JMP	773
	0x0225 00549 (main.go:41)	CMPQ	DX, SI
	0x0228 00552 (main.go:41)	JLS	611
	0x022a 00554 (main.go:41)	PCDATA	$1, $-1
	0x022a 00554 (<unknown line number>)	NOP
	0x022a 00554 (main.go:41)	MOVQ	-8(AX)(DX*8), AX
	0x022f 00559 ($GOROOT\src\strconv\itoa.go:35)	MOVL	$10, BX
	0x0234 00564 ($GOROOT\src\strconv\itoa.go:35)	PCDATA	$1, $5
	0x0234 00564 ($GOROOT\src\strconv\itoa.go:35)	CALL	strconv.FormatInt(SB)
	0x0239 00569 (main.go:41)	MOVQ	BX, CX
	0x023c 00572 (main.go:41)	MOVQ	AX, BX
	0x023f 00575 (main.go:41)	LEAQ	main..autotmp_35+80(SP), AX
	0x0244 00580 (main.go:41)	CALL	bufio.(*Writer).WriteString(SB)
	0x0249 00585 (main.go:42)	LEAQ	main..autotmp_35+80(SP), AX
	0x024e 00590 (main.go:42)	PCDATA	$1, $0
	0x024e 00590 (main.go:42)	CALL	bufio.(*Writer).Flush(SB)
	0x0253 00595 (main.go:43)	MOVQ	272(SP), BP
	0x025b 00603 (main.go:43)	ADDQ	$280, SP
	0x0262 00610 (main.go:43)	RET
	0x0263 00611 (main.go:41)	MOVQ	SI, AX
	0x0266 00614 (main.go:41)	MOVQ	DX, CX
	0x0269 00617 (main.go:41)	CALL	runtime.panicIndex(SB)
	0x026e 00622 (main.go:31)	INCQ	SI
	0x0271 00625 (main.go:31)	CMPQ	DX, SI
	0x0274 00628 (main.go:31)	JLE	536
	0x0276 00630 (main.go:32)	CMPQ	DX, CX
	0x0279 00633 (main.go:32)	JLS	795
	0x027f 00639 (main.go:32)	MOVQ	(AX)(CX*8), DI
	0x0283 00643 (main.go:31)	CMPQ	DX, SI
	0x0286 00646 (main.go:32)	JLS	784
	0x028c 00652 (main.go:32)	MOVQ	(AX)(SI*8), R8
	0x0290 00656 (main.go:32)	CMPQ	R8, DI
	0x0293 00659 (main.go:32)	JGE	622
	0x0295 00661 (main.go:31)	MOVQ	SI, main..autotmp_58+56(SP)
	0x029a 00666 (main.go:33)	LEAQ	main..autotmp_35+80(SP), AX
	0x029f 00671 (main.go:33)	LEAQ	go.string."====checkpoint"(SB), BX
	0x02a6 00678 (main.go:33)	MOVL	$14, CX
	0x02ab 00683 (main.go:33)	PCDATA	$1, $4
	0x02ab 00683 (main.go:33)	CALL	bufio.(*Writer).WriteString(SB)
	0x02b0 00688 (main.go:34)	MOVQ	main.i+32(SP), DX
	0x02b5 00693 (main.go:34)	MOVQ	main..autotmp_57+64(SP), SI
	0x02ba 00698 (main.go:34)	MOVQ	(SI)(DX*8), DI
	0x02be 00702 (main.go:34)	MOVQ	main..autotmp_58+56(SP), R8
	0x02c3 00707 (main.go:34)	MOVQ	(SI)(R8*8), R9
	0x02c7 00711 (main.go:34)	MOVQ	DI, (SI)(R8*8)
	0x02cb 00715 (main.go:34)	MOVQ	R9, (SI)(DX*8)
	0x02cf 00719 (main.go:35)	LEAQ	main..autotmp_35+80(SP), AX
	0x02d4 00724 (main.go:35)	LEAQ	go.string."====checkpoint"(SB), BX
	0x02db 00731 (main.go:35)	MOVL	$14, CX
	0x02e0 00736 (main.go:35)	CALL	bufio.(*Writer).WriteString(SB)
	0x02e5 00741 (main.go:32)	MOVQ	main..autotmp_57+64(SP), AX
	0x02ea 00746 (main.go:32)	MOVQ	main.i+32(SP), CX
	0x02ef 00751 (main.go:31)	MOVQ	main.N+48(SP), DX
	0x02f4 00756 (main.go:30)	MOVQ	main.j+24(SP), BX
	0x02f9 00761 (main.go:31)	MOVQ	main..autotmp_58+56(SP), SI
	0x02fe 00766 (main.go:31)	NOP
	0x0300 00768 (main.go:35)	JMP	622
	0x0305 00773 (main.go:38)	MOVQ	CX, AX
	0x0308 00776 (main.go:38)	MOVQ	DX, CX
	0x030b 00779 (main.go:38)	PCDATA	$1, $0
	0x030b 00779 (main.go:38)	CALL	runtime.panicIndex(SB)
	0x0310 00784 (main.go:32)	MOVQ	SI, AX
	0x0313 00787 (main.go:32)	MOVQ	DX, CX
	0x0316 00790 (main.go:32)	CALL	runtime.panicIndex(SB)
	0x031b 00795 (main.go:32)	MOVQ	CX, AX
	0x031e 00798 (main.go:32)	MOVQ	DX, CX
	0x0321 00801 (main.go:32)	CALL	runtime.panicIndex(SB)
	0x0326 00806 ($GOROOT\src\bufio\scan.go:281)	LEAQ	type.string(SB), AX
	0x032d 00813 ($GOROOT\src\bufio\scan.go:281)	LEAQ	main..stmp_0(SB), BX
	0x0334 00820 ($GOROOT\src\bufio\scan.go:281)	CALL	runtime.gopanic(SB)
	0x0339 00825 ($GOROOT\src\bufio\scan.go:281)	XCHGL	AX, AX
	0x033a 00826 ($GOROOT\src\bufio\scan.go:281)	NOP
	0x033a 00826 (main.go:14)	PCDATA	$1, $-1
	0x033a 00826 (main.go:14)	PCDATA	$0, $-2
	0x033a 00826 (main.go:14)	CALL	runtime.morestack_noctxt(SB)
	0x033f 00831 (main.go:14)	PCDATA	$0, $-1
	0x033f 00831 (main.go:14)	NOP
	0x0340 00832 (main.go:14)	JMP	0
	0x0000 4c 8d a4 24 68 ff ff ff 4d 3b 66 10 0f 86 28 03  L..$h...M;f...(.
	0x0010 00 00 48 81 ec 18 01 00 00 48 89 ac 24 10 01 00  ..H......H..$...
	0x0020 00 48 8d ac 24 10 01 00 00 48 8b 15 00 00 00 00  .H..$....H......
	0x0030 48 8d bc 24 90 00 00 00 0f 1f 84 00 00 00 00 00  H..$............
	0x0040 48 89 6c 24 f0 48 8d 6c 24 f0 e8 00 00 00 00 48  H.l$.H.l$......H
	0x0050 8b 6d 00 48 8d 35 00 00 00 00 48 89 b4 24 90 00  .m.H.5....H..$..
	0x0060 00 00 48 89 94 24 98 00 00 00 48 8d 15 00 00 00  ..H..$....H.....
	0x0070 00 48 89 94 24 a0 00 00 00 48 c7 84 24 a8 00 00  .H..$....H..$...
	0x0080 00 00 00 01 00 48 8b 35 00 00 00 00 48 89 74 24  .....H.5....H.t$
	0x0090 48 90 48 8d 05 00 00 00 00 bb 00 10 00 00 48 89  H.H...........H.
	0x00a0 d9 e8 00 00 00 00 44 0f 11 7c 24 50 44 0f 11 7c  ......D..|$PD..|
	0x00b0 24 60 44 0f 11 7c 24 70 44 0f 11 bc 24 80 00 00  $`D..|$pD...$...
	0x00c0 00 48 89 44 24 60 48 c7 44 24 68 00 10 00 00 48  .H.D$`H.D$h....H
	0x00d0 c7 44 24 70 00 10 00 00 48 8d 15 00 00 00 00 48  .D$p....H......H
	0x00e0 89 94 24 80 00 00 00 48 8b 54 24 48 48 89 94 24  ..$....H.T$HH..$
	0x00f0 88 00 00 00 90 80 bc 24 08 01 00 00 00 0f 1f 00  .......$........
	0x0100 0f 85 20 02 00 00 48 8d 0d 00 00 00 00 48 89 8c  .. ...H......H..
	0x0110 24 a0 00 00 00 48 8d 84 24 90 00 00 00 0f 1f 00  $....H..$.......
	0x0120 e8 00 00 00 00 48 8b 9c 24 b0 00 00 00 48 8b 8c  .....H..$....H..
	0x0130 24 b8 00 00 00 31 c0 e8 00 00 00 00 0f 1f 40 00  $....1........@.
	0x0140 e8 00 00 00 00 48 89 44 24 30 48 89 c3 48 89 d9  .....H.D$0H..H..
	0x0150 48 8d 05 00 00 00 00 e8 00 00 00 00 48 89 44 24  H...........H.D$
	0x0160 40 31 c9 eb 42 48 89 4c 24 28 48 8d 84 24 90 00  @1..BH.L$(H..$..
	0x0170 00 00 e8 00 00 00 00 48 8b 9c 24 b0 00 00 00 48  .......H..$....H
	0x0180 8b 8c 24 b8 00 00 00 31 c0 e8 00 00 00 00 e8 00  ..$....1........
	0x0190 00 00 00 48 8b 4c 24 28 48 8b 54 24 40 48 89 04  ...H.L$(H.T$@H..
	0x01a0 ca 48 ff c1 48 89 d0 48 8b 54 24 30 48 39 ca 7f  .H..H..H.T$0H9..
	0x01b0 b4 31 c9 eb 45 48 8b 0c c8 bb 0a 00 00 00 48 89  .1..EH........H.
	0x01c0 c8 e8 00 00 00 00 48 89 d9 48 89 c3 48 8d 44 24  ......H..H..H.D$
	0x01d0 50 e8 00 00 00 00 48 8d 44 24 50 bb 0a 00 00 00  P.....H.D$P.....
	0x01e0 e8 00 00 00 00 48 8b 4c 24 40 48 8b 54 24 30 48  .....H.L$@H.T$0H
	0x01f0 8b 74 24 18 48 89 c8 48 89 f1 48 8d 72 ff 66 90  .t$.H..H..H.r.f.
	0x0200 48 39 f1 7d 20 48 89 4c 24 20 48 8d 71 01 48 89  H9.} H.L$ H.q.H.
	0x0210 74 24 18 48 89 f3 eb 59 48 39 ca 77 98 0f 1f 00  t$.H...YH9.w....
	0x0220 e9 e0 00 00 00 48 39 f2 76 39 48 8b 44 d0 f8 bb  .....H9.v9H.D...
	0x0230 0a 00 00 00 e8 00 00 00 00 48 89 d9 48 89 c3 48  .........H..H..H
	0x0240 8d 44 24 50 e8 00 00 00 00 48 8d 44 24 50 e8 00  .D$P.....H.D$P..
	0x0250 00 00 00 48 8b ac 24 10 01 00 00 48 81 c4 18 01  ...H..$....H....
	0x0260 00 00 c3 48 89 f0 48 89 d1 e8 00 00 00 00 48 ff  ...H..H.......H.
	0x0270 c6 48 39 f2 7e a2 48 39 ca 0f 86 9c 00 00 00 48  .H9.~.H9.......H
	0x0280 8b 3c c8 48 39 f2 0f 86 84 00 00 00 4c 8b 04 f0  .<.H9.......L...
	0x0290 49 39 f8 7d d9 48 89 74 24 38 48 8d 44 24 50 48  I9.}.H.t$8H.D$PH
	0x02a0 8d 1d 00 00 00 00 b9 0e 00 00 00 e8 00 00 00 00  ................
	0x02b0 48 8b 54 24 20 48 8b 74 24 40 48 8b 3c d6 4c 8b  H.T$ H.t$@H.<.L.
	0x02c0 44 24 38 4e 8b 0c c6 4a 89 3c c6 4c 89 0c d6 48  D$8N...J.<.L...H
	0x02d0 8d 44 24 50 48 8d 1d 00 00 00 00 b9 0e 00 00 00  .D$PH...........
	0x02e0 e8 00 00 00 00 48 8b 44 24 40 48 8b 4c 24 20 48  .....H.D$@H.L$ H
	0x02f0 8b 54 24 30 48 8b 5c 24 18 48 8b 74 24 38 66 90  .T$0H.\$.H.t$8f.
	0x0300 e9 69 ff ff ff 48 89 c8 48 89 d1 e8 00 00 00 00  .i...H..H.......
	0x0310 48 89 f0 48 89 d1 e8 00 00 00 00 48 89 c8 48 89  H..H.......H..H.
	0x0320 d1 e8 00 00 00 00 48 8d 05 00 00 00 00 48 8d 1d  ......H......H..
	0x0330 00 00 00 00 e8 00 00 00 00 90 e8 00 00 00 00 90  ................
	0x0340 e9 bb fc ff ff                                   .....
	rel 3+0 t=23 type.*os.File+0
	rel 3+0 t=23 type.*os.File+0
	rel 3+0 t=23 type.string+0
	rel 44+4 t=14 os.Stdin+0
	rel 75+4 t=7 runtime.duffzero+322
	rel 86+4 t=14 go.itab.*os.File,io.Reader+0
	rel 109+4 t=14 bufio.ScanLines쨌f+0
	rel 136+4 t=14 os.Stdout+0
	rel 149+4 t=14 type.uint8+0
	rel 162+4 t=7 runtime.makeslice+0
	rel 219+4 t=14 go.itab.*os.File,io.Writer+0
	rel 265+4 t=14 bufio.ScanLines쨌f+0
	rel 289+4 t=7 bufio.(*Scanner).Scan+0
	rel 312+4 t=7 runtime.slicebytetostring+0
	rel 321+4 t=7 strconv.Atoi+0
	rel 339+4 t=14 type.int+0
	rel 344+4 t=7 runtime.makeslice+0
	rel 371+4 t=7 bufio.(*Scanner).Scan+0
	rel 394+4 t=7 runtime.slicebytetostring+0
	rel 399+4 t=7 strconv.Atoi+0
	rel 450+4 t=7 strconv.FormatInt+0
	rel 466+4 t=7 bufio.(*Writer).WriteString+0
	rel 481+4 t=7 bufio.(*Writer).WriteByte+0
	rel 565+4 t=7 strconv.FormatInt+0
	rel 581+4 t=7 bufio.(*Writer).WriteString+0
	rel 591+4 t=7 bufio.(*Writer).Flush+0
	rel 618+4 t=7 runtime.panicIndex+0
	rel 674+4 t=14 go.string."====checkpoint"+0
	rel 684+4 t=7 bufio.(*Writer).WriteString+0
	rel 727+4 t=14 go.string."====checkpoint"+0
	rel 737+4 t=7 bufio.(*Writer).WriteString+0
	rel 780+4 t=7 runtime.panicIndex+0
	rel 791+4 t=7 runtime.panicIndex+0
	rel 802+4 t=7 runtime.panicIndex+0
	rel 809+4 t=14 type.string+0
	rel 816+4 t=14 main..stmp_0+0
	rel 821+4 t=7 runtime.gopanic+0
	rel 827+4 t=7 runtime.morestack_noctxt+0
go.cuinfo.producer.<unlinkable> SDWARFCUINFO dupok size=0
	0x0000 72 65 67 61 62 69                                regabi
go.cuinfo.packagename.main SDWARFCUINFO dupok size=0
	0x0000 6d 61 69 6e                                      main
go.info.bufio.NewScanner$abstract SDWARFABSFCN dupok size=29
	0x0000 05 62 75 66 69 6f 2e 4e 65 77 53 63 61 6e 6e 65  .bufio.NewScanne
	0x0010 72 00 01 01 13 72 00 00 00 00 00 00 00           r....r.......
	rel 0+0 t=22 type.*bufio.Scanner+0
	rel 0+0 t=22 type.io.Reader+0
	rel 24+4 t=31 go.info.io.Reader+0
go.info.bufio.NewWriter$abstract SDWARFABSFCN dupok size=28
	0x0000 05 62 75 66 69 6f 2e 4e 65 77 57 72 69 74 65 72  .bufio.NewWriter
	0x0010 00 01 01 13 77 00 00 00 00 00 00 00              ....w.......
	rel 0+0 t=22 type.*bufio.Writer+0
	rel 0+0 t=22 type.io.Writer+0
	rel 23+4 t=31 go.info.io.Writer+0
go.info.bufio.NewWriterSize$abstract SDWARFABSFCN dupok size=62
	0x0000 05 62 75 66 69 6f 2e 4e 65 77 57 72 69 74 65 72  .bufio.NewWriter
	0x0010 53 69 7a 65 00 01 01 13 77 00 00 00 00 00 00 13  Size....w.......
	0x0020 73 69 7a 65 00 00 00 00 00 00 0e 62 00 c9 04 00  size.......b....
	0x0030 00 00 00 0e 6f 6b 00 c9 04 00 00 00 00 00        ....ok........
	rel 0+0 t=22 type.*bufio.Writer+0
	rel 0+0 t=22 type.bool+0
	rel 0+0 t=22 type.int+0
	rel 0+0 t=22 type.io.Writer+0
	rel 27+4 t=31 go.info.io.Writer+0
	rel 38+4 t=31 go.info.int+0
	rel 47+4 t=31 go.info.*bufio.Writer+0
	rel 57+4 t=31 go.info.bool+0
go.info.bufio.(*Scanner).Split$abstract SDWARFABSFCN dupok size=47
	0x0000 05 62 75 66 69 6f 2e 28 2a 53 63 61 6e 6e 65 72  .bufio.(*Scanner
	0x0010 29 2e 53 70 6c 69 74 00 01 01 13 73 00 00 00 00  ).Split....s....
	0x0020 00 00 13 73 70 6c 69 74 00 00 00 00 00 00 00     ...split.......
	rel 0+0 t=22 type.*bufio.Scanner+0
	rel 0+0 t=22 type.bufio.SplitFunc+0
	rel 30+4 t=31 go.info.*bufio.Scanner+0
	rel 42+4 t=31 go.info.bufio.SplitFunc+0
go.info.bufio.(*Scanner).Text$abstract SDWARFABSFCN dupok size=34
	0x0000 05 62 75 66 69 6f 2e 28 2a 53 63 61 6e 6e 65 72  .bufio.(*Scanner
	0x0010 29 2e 54 65 78 74 00 01 01 13 73 00 00 00 00 00  ).Text....s.....
	0x0020 00 00                                            ..
	rel 0+0 t=22 type.*bufio.Scanner+0
	rel 0+0 t=22 type.string+0
	rel 29+4 t=31 go.info.*bufio.Scanner+0
go.info.strconv.Itoa$abstract SDWARFABSFCN dupok size=25
	0x0000 05 73 74 72 63 6f 6e 76 2e 49 74 6f 61 00 01 01  .strconv.Itoa...
	0x0010 13 69 00 00 00 00 00 00 00                       .i.......
	rel 0+0 t=22 type.int+0
	rel 0+0 t=22 type.string+0
	rel 20+4 t=31 go.info.int+0
main..inittask SNOPTRDATA size=48
	0x0000 00 00 00 00 00 00 00 00 03 00 00 00 00 00 00 00  ................
	0x0010 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................
	0x0020 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................
	rel 24+8 t=1 bufio..inittask+0
	rel 32+8 t=1 os..inittask+0
	rel 40+8 t=1 strconv..inittask+0
go.string."Split called after Scan" SRODATA dupok size=23
	0x0000 53 70 6c 69 74 20 63 61 6c 6c 65 64 20 61 66 74  Split called aft
	0x0010 65 72 20 53 63 61 6e                             er Scan
go.itab.*os.File,io.Reader SRODATA dupok size=32
	0x0000 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................
	0x0010 5a 22 ee 60 00 00 00 00 00 00 00 00 00 00 00 00  Z".`............
	rel 0+8 t=1 type.io.Reader+0
	rel 8+8 t=1 type.*os.File+0
	rel 24+8 t=-32767 os.(*File).Read+0
go.itab.*os.File,io.Writer SRODATA dupok size=32
	0x0000 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................
	0x0010 5a 22 ee 60 00 00 00 00 00 00 00 00 00 00 00 00  Z".`............
	rel 0+8 t=1 type.io.Writer+0
	rel 8+8 t=1 type.*os.File+0
	rel 24+8 t=-32767 os.(*File).Write+0
go.itab.*bufio.Writer,io.Writer SRODATA dupok size=32
	0x0000 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................
	0x0010 d4 85 56 8c 00 00 00 00 00 00 00 00 00 00 00 00  ..V.............
	rel 0+8 t=1 type.io.Writer+0
	rel 8+8 t=1 type.*bufio.Writer+0
	rel 24+8 t=-32767 bufio.(*Writer).Write+0
go.string."====checkpoint" SRODATA dupok size=14
	0x0000 3d 3d 3d 3d 63 68 65 63 6b 70 6f 69 6e 74        ====checkpoint
main..stmp_0 SRODATA static size=16
	0x0000 00 00 00 00 00 00 00 00 17 00 00 00 00 00 00 00  ................
	rel 0+8 t=1 go.string."Split called after Scan"+0
runtime.memequal64쨌f SRODATA dupok size=8
	0x0000 00 00 00 00 00 00 00 00                          ........
	rel 0+8 t=1 runtime.memequal64+0
runtime.gcbits.01 SRODATA dupok size=1
	0x0000 01                                               .
type..namedata.*[]int- SRODATA dupok size=8
	0x0000 00 06 2a 5b 5d 69 6e 74                          ..*[]int
type.*[]int SRODATA dupok size=56
	0x0000 08 00 00 00 00 00 00 00 08 00 00 00 00 00 00 00  ................
	0x0010 60 88 d2 70 08 08 08 36 00 00 00 00 00 00 00 00  `..p...6........
	0x0020 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................
	0x0030 00 00 00 00 00 00 00 00                          ........
	rel 24+8 t=1 runtime.memequal64쨌f+0
	rel 32+8 t=1 runtime.gcbits.01+0
	rel 40+4 t=5 type..namedata.*[]int-+0
	rel 48+8 t=1 type.[]int+0
type.[]int SRODATA dupok size=56
	0x0000 18 00 00 00 00 00 00 00 08 00 00 00 00 00 00 00  ................
	0x0010 83 73 77 99 02 08 08 17 00 00 00 00 00 00 00 00  .sw.............
	0x0020 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................
	0x0030 00 00 00 00 00 00 00 00                          ........
	rel 32+8 t=1 runtime.gcbits.01+0
	rel 40+4 t=5 type..namedata.*[]int-+0
	rel 44+4 t=-32763 type.*[]int+0
	rel 48+8 t=1 type.int+0
runtime.gcbits.9620 SRODATA dupok size=2
	0x0000 96 20                                            . 
runtime.gcbits.86 SRODATA dupok size=1
	0x0000 86                                               .
type..importpath.bufio. SRODATA dupok size=7
	0x0000 00 05 62 75 66 69 6f                             ..bufio
type..importpath.os. SRODATA dupok size=4
	0x0000 00 02 6f 73                                      ..os
type..importpath.strconv. SRODATA dupok size=9
	0x0000 00 07 73 74 72 63 6f 6e 76                       ..strconv
bufio.ScanLines쨌f SRODATA dupok size=8
	0x0000 00 00 00 00 00 00 00 00                          ........
	rel 0+8 t=1 bufio.ScanLines+0
gclocals쨌3CgL1OMj4PK20UKKkS8Bfw== SRODATA dupok size=8
	0x0000 06 00 00 00 00 00 00 00                          ........
gclocals쨌SdD0uXGADlloNMAQcAFuzg== SRODATA dupok size=32
	0x0000 06 00 00 00 1a 00 00 00 00 00 00 00 02 58 82 00  .............X..
	0x0010 18 5a 82 00 19 5a 82 00 19 02 00 00 18 02 00 00  .Z...Z..........
main.main.stkobj SRODATA static size=40
	0x0000 02 00 00 00 00 00 00 00 40 ff ff ff 40 00 00 00  ........@...@...
	0x0010 40 00 00 00 00 00 00 00 80 ff ff ff 80 00 00 00  @...............
	0x0020 70 00 00 00 00 00 00 00                          p.......
	rel 20+4 t=5 runtime.gcbits.86+0
	rel 36+4 t=5 runtime.gcbits.9620+0
